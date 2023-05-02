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
  
      // make a POST request to the server using fetch API
      fetch("http://localhost:8080/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(formData)
      })
      .then(response => response.json())
      .then(data => {
        // handle the response from the server
        console.log(data);
      })
      .catch(error => {
        // handle errors
        console.error(error);
      });
    }
  
    return isValid;
  }
  