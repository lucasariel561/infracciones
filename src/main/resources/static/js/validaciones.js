(function loadSwal() {
    if (window.Swal) return;
    const s = document.createElement('script');
    s.src = 'https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.all.min.js';
    document.head.appendChild(s);
})();

window.showToast = function(msg, type = 'success') {
    let container = document.getElementById('toast-container');
    if (!container) {
        container = document.createElement('div');
        container.id = 'toast-container';
        document.body.appendChild(container);
    }

    const icons = { success: '✓', error: '✗', info: 'ℹ' };
    const toast = document.createElement('div');
    toast.className = `toast-msg toast-${type}`;
    toast.innerHTML = `<span class="toast-icon">${icons[type] || icons.info}</span><span>${msg}</span>`;
    container.appendChild(toast);

    setTimeout(() => {
        toast.classList.add('toast-out');
        setTimeout(() => toast.remove(), 350);
    }, 3500);
};

window.confirmarGuardado = function() {
    if (!window.Swal) {
        return confirm('¿Estás seguro de que deseas guardar este registro?');
    }

    Swal.fire({
        title: '¿Guardar registro?',
        text: 'El dato quedará almacenado en el sistema.',
        icon: 'question',
        showCancelButton: true,
        confirmButtonText: 'Sí, guardar',
        cancelButtonText: 'Cancelar',
        confirmButtonColor: '#1a1f2e',
        cancelButtonColor: '#6b7280',
        borderRadius: '16px',
        customClass: {
            popup:          'swal-popup-custom',
            confirmButton:  'swal-btn-confirm',
            cancelButton:   'swal-btn-cancel',
        }
    }).then(result => {
        if (result.isConfirmed) {
            const form = document.querySelector('form[data-submitting]') ||
                document.activeElement.closest('form');
            if (form) form.submit();
        }
    });

    return false;
};

document.addEventListener('DOMContentLoaded', () => {

    // Interceptar todos los forms para usar SweetAlert
    document.querySelectorAll('form[onsubmit]').forEach(form => {
        form.removeAttribute('onsubmit');
        form.addEventListener('submit', function(e) {
            e.preventDefault();
            if (!validarFormulario(this)) return;

            if (!window.Swal) { this.submit(); return; }

            Swal.fire({
                title: '¿Guardar registro?',
                text: 'El dato quedará almacenado en el sistema.',
                icon: 'question',
                showCancelButton: true,
                confirmButtonText: 'Sí, guardar',
                cancelButtonText: 'Cancelar',
                confirmButtonColor: '#1a1f2e',
                cancelButtonColor: '#6b7280',
            }).then(result => {
                if (result.isConfirmed) form.submit();
            });
        });
    });

    document.querySelectorAll('.form-control, .form-select').forEach(input => {
        input.addEventListener('blur', () => validarCampo(input));
        input.addEventListener('input', () => {
            if (input.classList.contains('is-invalid')) validarCampo(input);
        });
    });

    document.querySelectorAll('input[style*="uppercase"]').forEach(inp => {
        inp.addEventListener('input', () => { inp.value = inp.value.toUpperCase(); });
    });


    const CAMPOS_SOLO_LETRAS = ['nombres', 'apellidos', 'nombres_completos', 'apellidos_completos'];
    // Solo números: placa, legajo, dni, año, montos
    const CAMPOS_SOLO_NUMEROS = ['numeroPlaca', 'numeroLegajo', 'documentoIdentidad', 'anioPatentamiento', 'montoFinal', 'montoBase'];

    document.querySelectorAll('input[type="text"], input[type="number"]').forEach(input => {
        const name = input.name || input.id || '';

        const soloLetras   = CAMPOS_SOLO_LETRAS.some(n => name.toLowerCase().includes(n.toLowerCase()));
        const soloNumeros  = input.type === 'number' ||
            CAMPOS_SOLO_NUMEROS.some(n => name.toLowerCase().includes(n.toLowerCase()));

        if (soloLetras) {
            input.addEventListener('keypress', e => {
                // Permitir letras (incluyendo tildes y ñ), espacios y teclas de control
                if (!/^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\s]$/.test(e.key) && !e.ctrlKey && !e.metaKey) {
                    e.preventDefault();
                    sacudirCampo(input);
                }
            });
            input.addEventListener('paste', e => {
                const texto = (e.clipboardData || window.clipboardData).getData('text');
                if (/[^a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\s]/.test(texto)) {
                    e.preventDefault();
                    sacudirCampo(input);
                }
            });
        }

        if (soloNumeros) {
            input.addEventListener('keypress', e => {
                // Permitir dígitos y teclas de control
                if (!/^\d$/.test(e.key) && !e.ctrlKey && !e.metaKey) {
                    e.preventDefault();
                    sacudirCampo(input);
                }
            });
            input.addEventListener('paste', e => {
                const texto = (e.clipboardData || window.clipboardData).getData('text');
                if (/\D/.test(texto)) {
                    e.preventDefault();
                    sacudirCampo(input);
                }
            });
        }
    });

    initTableSearch();
    animarFilas();
    const params = new URLSearchParams(window.location.search);
    if (params.get('guardado') === '1') {
        showToast('¡Registro guardado exitosamente!', 'success');
        // Limpiar URL sin recargar
        history.replaceState({}, '', window.location.pathname);
    }
});

function validarCampo(input) {
    const val = input.value.trim();
    const required = input.hasAttribute('required');
    let valid = true;
    let msg = '';

    if (required && !val) {
        valid = false; msg = 'Este campo es obligatorio.';
    } else if (input.type === 'number' && val && isNaN(Number(val))) {
        valid = false; msg = 'Ingresá un número válido.';
    } else if (input.type === 'date' && val) {
        const date = new Date(val);
        if (isNaN(date.getTime())) { valid = false; msg = 'Fecha inválida.'; }
    }

    input.classList.toggle('is-valid',   valid && !!val);
    input.classList.toggle('is-invalid', !valid);

    let feedback = input.nextElementSibling;
    if (!feedback || !feedback.classList.contains('field-feedback')) {
        feedback = document.createElement('div');
        feedback.className = 'field-feedback';
        feedback.style.cssText = 'font-size:12px; margin-top:4px; font-weight:500;';
        input.insertAdjacentElement('afterend', feedback);
    }
    feedback.textContent  = valid ? '' : msg;
    feedback.style.color  = valid ? 'var(--success)' : 'var(--danger)';

    return valid;
}

function validarFormulario(form) {
    const campos = form.querySelectorAll('.form-control[required], .form-select[required]');
    let ok = true;
    campos.forEach(c => { if (!validarCampo(c)) ok = false; });
    if (!ok) {
        const primero = form.querySelector('.is-invalid');
        if (primero) primero.focus();
    }
    return ok;
}

function initTableSearch() {
    document.querySelectorAll('.table-custom').forEach(table => {
        // Crear el input de búsqueda
        const wrapper = document.createElement('div');
        wrapper.className = 'table-search mb-3';
        wrapper.innerHTML = `
            <span class="search-icon">⌕</span>
            <input type="text" class="form-control" placeholder="Buscar en la tabla…" autocomplete="off">
        `;

        const container = table.closest('.card-custom') || table.parentElement;
        container.insertBefore(wrapper, table);

        const input = wrapper.querySelector('input');
        const rows = Array.from(table.querySelectorAll('tbody tr'));

        // Contador de filas visibles
        const counter = document.createElement('span');
        counter.className = 'row-count ms-2';
        counter.textContent = `${rows.length} registros`;
        wrapper.appendChild(counter);

        input.addEventListener('input', () => {
            const q = input.value.toLowerCase().trim();
            let visible = 0;
            rows.forEach(row => {
                const text = row.textContent.toLowerCase();
                const match = !q || text.includes(q);
                row.style.display = match ? '' : 'none';
                if (match) visible++;
            });
            counter.textContent = `${visible} de ${rows.length} registros`;
        });
    });
}
function animarFilas() {
    document.querySelectorAll('.table-custom tbody tr').forEach((row, i) => {
        row.style.animationDelay = `${i * 40}ms`;
    });
}

function sacudirCampo(input) {
    if (input.classList.contains('shake')) return;
    input.classList.add('shake');
    setTimeout(() => input.classList.remove('shake'), 400);
}

const swalStyle = document.createElement('style');
swalStyle.textContent = `
    .swal2-popup {
        font-family: 'DM Sans', sans-serif !important;
        border-radius: 20px !important;
        padding: 2rem !important;
    }
    .swal2-title { font-weight: 600 !important; color: #1a1f2e !important; }
    .swal2-confirm, .swal2-cancel {
        border-radius: 10px !important;
        font-family: 'DM Sans', sans-serif !important;
        font-weight: 500 !important;
        padding: 10px 24px !important;
    }
`;
document.head.appendChild(swalStyle);