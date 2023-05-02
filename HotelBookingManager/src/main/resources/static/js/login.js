function validateLoginForm() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    let isValid = true;
  
    // validate username
    if (username === "") {
      document.getElementById("username-error").textContent = "Please enter your username";
      isValid = false;
    } else {
      document.getElementById("username-error").textContent = "";
    }
  
    // validate password
    if (password === "") {
      document.getElementById("password-error").textContent = "Please enter your password";
      isValid = false;
    } else {
      document.getElementById("password-error").textContent = "";
    }
    if (isValid) {

        // create an object with the form data
        const formData = {
          username: username,
          password: password
        };
    
        //make a POST request to the server using fetch API
        fetch("http://localhost:8080/checklogin", {
          method: 'POST', // *GET, POST, PUT, DELETE, etc.
          headers: {
            "Content-Type": "application/json",
            // 'Content-Type': 'application/x-www-form-urlencoded',
          },
          body: JSON.stringify(formData), // body data type must match "Content-Type",
          cache: 'no-cache'
        })
        .then(function(response){
          return response.json();
        })
        .then(function(response){
          console.log(hotels);
        })
        
      } 
    

 }