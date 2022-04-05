let users, roles;
adminPage()


function adminPage() {

    fetch("/api/users/roles").then(response => {
        response.json().then(allRoles => {
            roles = allRoles;
        })
    })
    fetch("/api/users").then(response => {
        response.json().then(listOfUsers => {
            users = listOfUsers;
            adminTable()
        })
    })
}


function userRole(user) {
    let userRole = '';
    user.roles.forEach(role => {
        userRole += `<li>${role}</li>`;
    })
    return userRole;
}

// Admin table
function adminTable() {
    $("#allUsers").empty();
    users.forEach(user => {
        let tableFilling = `$(
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.surname}</td>
                            <td>${user.age}</td>
                            <td>${user.email}</td>
                            <td>${userRole(user)}</td>
                            <td><button class='btn btn-success' data-bs-toggle='modal' data-bs-target='#editUserButtonModal' onclick='editButtonModal(${user.id})' >Edit</button></td>
                            <td><button class='btn btn-danger' data-bs-toggle='modal' data-bs-target='#deleteBtnUserModal' onclick='deleteButtonModal(${user.id})' >Delete</button></td>
                            </td>
                            <td>
                            </td>
                            </tr>
                )`;
        $("#allUsers").append(tableFilling)
    });

}

// Modal edit user
function editButtonModal(id) {
    let user = findUserById(id);
    $("#editUserModalID").val(user.id);
    $("#editUserModalName").val(user.name);
    $("#editUserModalSurname").val(user.surname);
    $("#editUserModalAge").val(user.age);
    $("#editUserModalEmail").val(user.email);
    $("#editUserModalPassword").val(user.password);
    roles.forEach(role => {
        $("#editUserModalRoles").append(
            "<option value=".concat(role, ">", role + "</option>")
        );
    });

}


function editUserModalSubmitButton() {
    let form = $("#editUserModalForm");
    $.ajax({
        type: "PUT",
        url: "api/users/" + $("#editUserModalID").val(),
        data: form.serialize(),
        success: function () {
            form.submit()
            $('.modal-backdrop').remove();
        }
    })
}


//Modal delete user
function deleteButtonModal(id) {
    let user = findUserById(id);
    $("#deleteUserModalID").val(user.id);
    $("#deleteUserModalName").val(user.name);
    $("#deleteUserModalSurname").val(user.surname);
    $("#deleteUserModalAge").val(user.age);
    $("#deleteUserModalEmail").val(user.email);
    $("#deleteUserModalPassword").val(user.password);
    $("#deleteUserModalRoles").empty();
    roles.forEach(role => {
        $("#deleteUserModalRoles").append(
            "<option value=".concat(role, ">", role + "</option>")
        );
    });
}

function deleteUserModalSubmitBtn() {
    $.ajax({
        type: "DELETE",
        url: "api/users/" + $("#deleteUserModalID").val(),
        success: function () {
            users = users.filter(user => user.id !== $("#deleteUserModalID").val());
        }
    })
}

function findUserById(id) {
    return users.find(user => user.id === id);
}


//Add new user
function addSubmit() {
    let form = $("#newForm");
    $.ajax({
        type: "POST",
        url: "api/users",
        data: form.serialize(),
        success: function () {
            form.submit()
        }
    })
}





