fetch("/api/user")
    .then(res => res.json())
    .then(user => {
        document.querySelector('#userTableBody').innerHTML = `
                                <td>${user.id}</td>
                                <td>${user.name}</td>
                                <td>${user.surname}</td>
                                <td>${user.age}</td>
                                <td>${user.email}</td>
                                `;
    })

