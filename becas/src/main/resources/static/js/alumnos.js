document.addEventListener("DOMContentLoaded", () => {
    cargarAlumnos();
});

function renderTabla(alumnos) {
    let tabla = document.getElementById("tabla-alumnos");
    tabla.innerHTML = "";

    alumnos.forEach(alumno => {
        tabla.innerHTML += `
        <tr>
            <td>${alumno.id}</td>
            <td>${alumno.nombre}</td>
            <td>${alumno.matricula}</td>
            <td>${alumno.carrera}</td>
            <td>${alumno.promedio}</td>
            <td>
                <button class="btn btn-warning btn-sm"
                    onclick="abrirModal(${alumno.id}, '${alumno.nombre}', '${alumno.matricula}', '${alumno.carrera}', ${alumno.promedio})">
                    Editar
                </button>

                <button class="btn btn-danger btn-sm"
                    onclick="eliminarAlumno(${alumno.id})">
                    Eliminar
                </button>
            </td>
        </tr>
        `;
    });
}

function cargarAlumnos() {
    fetch("http://localhost:8080/alumnos")
        .then(res => res.json())
        .then(data => renderTabla(data));
}

function buscarAlumno() {
    const id = document.getElementById("buscarId").value;

    fetch(`http://localhost:8080/alumnos/${id}`)
        .then(res => res.json())
        .then(alumno => {
            renderTabla([alumno]);
        })
        .catch(() => {
            document.getElementById("tabla-alumnos").innerHTML =
                `<tr><td colspan="6" class="text-center text-danger">Alumno no encontrado</td></tr>`;
        });
}

function agregarAlumno() {
    const nombre = document.getElementById("nombre").value;
    const matricula = document.getElementById("matricula").value;
    const carrera = document.getElementById("carrera").value;
    const promedio = document.getElementById("promedio").value;

    fetch("http://localhost:8080/alumnos", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            nombre,
            matricula,
            carrera,
            promedio: parseFloat(promedio)
        })
    })
        .then(res => res.json())
        .then(() => cargarAlumnos());
}

function eliminarAlumno(id) {
    fetch(`http://localhost:8080/alumnos/${id}`, {
        method: "DELETE"
    })
        .then(() => cargarAlumnos());
}

function abrirModal(id, nombre, matricula, carrera, promedio) {
    document.getElementById("editId").value = id;
    document.getElementById("editNombre").value = nombre;
    document.getElementById("editMatricula").value = matricula;
    document.getElementById("editCarrera").value = carrera;
    document.getElementById("editPromedio").value = promedio;

    let modal = new bootstrap.Modal(document.getElementById('modalEditar'));
    modal.show();
}

function guardarEdicion() {
    let id = document.getElementById("editId").value;
    let nombre = document.getElementById("editNombre").value;
    let matricula = document.getElementById("editMatricula").value;
    let carrera = document.getElementById("editCarrera").value;
    let promedio = document.getElementById("editPromedio").value;

    fetch(`http://localhost:8080/alumnos/${id}`, {
        method: "PATCH",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            nombre,
            matricula,
            carrera,
            promedio: parseFloat(promedio)
        })
    })
        .then(() => {
            cargarAlumnos();
            bootstrap.Modal.getInstance(document.getElementById('modalEditar')).hide();
        });
}