'use strict';

let forms = document.querySelectorAll('.needs-validation');

[].slice.call(forms).forEach( form => {
  form.addEventListener('submit', event => {
    if (!form.checkValidity()) {
      event.preventDefault();
      event.stopPropagation();
    }
    form.classList.add('was-validated');
  }, false)
});