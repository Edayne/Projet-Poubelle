let formulaire = document.getElementById('formulaire');


formulaire.addEventListener('submit', function(e) {
    e.preventDefault();
    TestFormulaireText('nom', /^[a-zA-Z-]+$/, 'error-name', 'Veuillez remplir la case', 'Le nom doit-être réécrit');
    TestFormulaireText('prenom', /^[a-zA-Z-]+$/, 'error-prenom', 'Veuillez remplir la case', 'Le prenom doit-être réécrit'); 
    TestFormulaireText('sujet', /^[a-zA-Z-\s]+$/, 'error-sujet', 'Veuillez remplir la case', 'Le sujet doit-être réécrit');
    TestFormulaireText('email', /^\s*$|^[^\s@]+@[^\s@]+\.[^\s@]+$/, 'error-email', 'Veuillez remplir la case', 'Veuillez entrer une adresse e-mail valide');
    TestFormulaireDate('naissance','error-date','Veuillez remplir la case'); 
    TestFormulaireGenre('genre'); 
    /*test*/
    // Vérifie s'il y a des erreurs dans le formulaire
    let errors = document.querySelectorAll('.error');
    if (errors.length === 0) {
        // Si le formulaire est valide, redirige la page
        window.location.href = 'index.html';
    }
});

function TestFormulaireText(id,regex,error,textevide,texteinvalide){
    let myInput = document.getElementById(id);
    let myError = document.getElementById(error);

    if (regex.test(myInput.value) == false && myInput.value != "") {
        myError.innerHTML = texteinvalide;
        myError.style.color = 'red';
        myInput.classList.add('error');
    }
    else if (myInput.value == "") {
        myError.innerHTML = textevide;
        myError.style.color = 'red';
        myInput.classList.add('error');
    } 
    else {
        myError.innerHTML = "";
        myError.style.color = 'white';
        myInput.classList.remove('error');
    }
    if(id == 'email' && myInput.value == ""){
        myError.innerHTML = textevide;
        myError.style.color = 'red';
        myInput.classList.add('error');
    }
}



function TestFormulaireGenre(inputName) {
    let radios = document.getElementsByName(inputName);
    let isValid = false;
    for (let i = 0; i < radios.length; i++) {
      if (radios[i].checked) {
        isValid = true;
        break;
      }
    }
    if (!isValid) {
      let errorElement = document.getElementById('error-genre');
      errorElement.innerHTML = "Veuillez sélectionner une option";
      errorElement.style.color = 'red';
      return false;
    } else {
      let errorElement = document.getElementById('error-genre');
      errorElement.innerHTML = "";
      errorElement.style.color = 'white';
    }
  }

function TestFormulaireDate(id,error,textevide){
  let myInput = document.getElementById(id);
  let myError = document.getElementById(error);
  let date = new Date();

  if (myInput.value == "") {
    myError.innerHTML = textevide;
    myError.style.color = 'red';
    myInput.classList.add('error');
  }
  else if (new Date(myInput.value).getTime() > date.getTime()){
    myError.innerHTML = 'La date est incorrecte';
    myError.style.color = 'red';
    myInput.classList.add('error');
  }
  else {
    myError.innerHTML = "";
    myError.style.color = 'white';
    myInput.classList.remove('error');
  }
}




