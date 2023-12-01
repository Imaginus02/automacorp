
/* Room div
    <div class="border border-secondary rounded p-2 mb-2">
        <div class="top-row d-flex">
            <div class="fw-bold pe-3">Room 1</div>
            <div class="text-muted">Floor 1</div>
        </div>
        <hr>
        <div class="border border-secondary rounded p-2 mb-2">
            <div class="top-row d-flex">
                <div class="fw-bold pe-3">Window 1</div>

                <div class="ms-4">
                    <span class="">&#x2B24;</span> Open
                </div>
            </div>
        </div>

        <div class="border border-secondary rounded p-2 mb-2">
            <div class="top-row d-flex">
                <div class="fw-bold pe-3">Window 2</div>

                <div class="ms-4">
                    <span class="icon">&#x2B24;</span> Closed
                </div>
            </div>
        </div>
    </div>
 */

function generateUserDiv(user) {
    var row = document.createElement('tr');
    var userId = document.createElement("td");
    var userEmail = document.createElement("td");
    var userUsername = document.createElement("td");

    userId.textContent = user.id;
    userEmail.textContent = user.email;
    userUsername.textContent = user.username;

    row.appendChild(userId);
    row.appendChild(userEmail);
    row.appendChild(userUsername);
    return row;
}


function retrieveUser() {
    var list = document.getElementById("userList");
    fetch('/users/json') // Replace with the correct URL of your endpoint
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json(); // Parse the JSON response
        })
        .then(users => {
            // Use the JSON data in your JavaScript code
            console.log(users);
            users.forEach(user => {
                list.appendChild(generateUserDiv(user));
            })
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
}

retrieveUser();