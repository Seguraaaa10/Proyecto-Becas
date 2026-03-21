document.addEventListener("DOMContentLoaded", () => {
    cargarBecas();
});

function cargarBecas() {
    fetch("http://localhost:8080/becas")
        .then(res => res.json())
        .then(data => pintarTabla(data));
}

function buscarBeca() {
    const id = document.getElementById("buscarId").value;

    if (!id) {
        alert("Ingresa un ID");
        return;
    }

    fetch(`http://localhost:8080/becas/${id}`)
        .then(res => res.json())
        .then(data => pintarTabla([data]));
}

function pintarTabla(data) {
    let tabla = document.getElementById("tabla-becas");
    tabla.innerHTML = "";

    data.forEach(beca => {
        tabla.innerHTML += `
        <tr>
            <td>${beca.id}</td>
            <td>${beca.nombre}</td>
            <td>${beca.montoTotal}</td>
            <td>${beca.estadoConvocatoria}</td>
            <td>
                <button class="btn btn-warning btn-sm"
                    onclick="abrirModal(${beca.id}, '${beca.nombre}', ${beca.montoTotal}, '${beca.estadoConvocatoria}')">
                    Editar
                </button>

                <button class="btn btn-danger btn-sm"
                    onclick="eliminarBeca(${beca.id})">
                    Eliminar
                </button>
            </td>
        </tr>
        `;
    });
}

function agregarBeca() {
    const nombre = document.getElementById("nombre").value;
    const monto = document.getElementById("monto").value;
    const estado = document.getElementById("estado").value;
    const periodicidad = document.getElementById("periodicidad").value;

    fetch("http://localhost:8080/becas", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            nombre: nombre,
            montoTotal: parseFloat(monto),
            periodicidad: periodicidad,
            estadoConvocatoria: estado
        })
    })
        .then(() => cargarBecas());
}

function eliminarBeca(id) {
    fetch(`http://localhost:8080/becas/${id}`, {
        method: "DELETE"
    })
        .then(() => cargarBecas());
}

function abrirModal(id, nombre, monto, estado) {
    document.getElementById("editId").value = id;
    document.getElementById("editNombre").value = nombre;
    document.getElementById("editMonto").value = monto;
    document.getElementById("editEstado").value = estado;

    new bootstrap.Modal(document.getElementById('modalEditar')).show();
}

function guardarEdicion() {
    let id = document.getElementById("editId").value;
    let nombre = document.getElementById("editNombre").value;
    let monto = document.getElementById("editMonto").value;
    let estado = document.getElementById("editEstado").value;

    fetch(`http://localhost:8080/becas/${id}`, {
        method: "PATCH",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            nombre: nombre,
            montoTotal: parseFloat(monto),
            estadoConvocatoria: estado
        })
    })
        .then(() => {
            cargarBecas();
            bootstrap.Modal.getInstance(document.getElementById('modalEditar')).hide();
        });
}