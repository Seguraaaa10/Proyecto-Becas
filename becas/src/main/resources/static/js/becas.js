document.addEventListener("DOMContentLoaded", () => {
    cargarBecas();
});

function cargarBecas() {
    fetch("http://localhost:8080/becas")
        .then(res => res.json())
        .then(data => pintarTabla(data));
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
            <td>${beca.mensualidad}</td>
            <td>${beca.duracionMeses}</td>
            <td>${beca.periodicidad}</td>
            <td>${beca.estadoConvocatoria}</td>
            <td>
                <button class="btn btn-warning btn-sm"
                    onclick="abrirModal(
                        ${beca.id},
                        '${beca.nombre}',
                        ${beca.montoTotal},
                        ${beca.mensualidad},
                        ${beca.duracionMeses},
                        '${beca.periodicidad}',
                        '${beca.estadoConvocatoria}'
                    )">
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
    const mensualidad = document.getElementById("mensualidad").value;
    const duracion = document.getElementById("duracion").value;
    const periodicidad = document.getElementById("periodicidad").value;
    const estado = document.getElementById("estado").value;

    fetch("http://localhost:8080/becas", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            nombre,
            montoTotal: parseFloat(monto),
            mensualidad: parseFloat(mensualidad),
            duracionMeses: parseInt(duracion),
            periodicidad,
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

function abrirModal(id, nombre, monto, mensualidad, duracion, periodicidad, estado) {

    document.getElementById("editId").value = id;
    document.getElementById("editNombre").value = nombre;
    document.getElementById("editMonto").value = monto;
    document.getElementById("editMensualidad").value = mensualidad;
    document.getElementById("editDuracion").value = duracion;
    document.getElementById("editPeriodicidad").value = periodicidad;
    document.getElementById("editEstado").value = estado;

    new bootstrap.Modal(document.getElementById('modalEditar')).show();
}

function guardarEdicion() {

    let id = document.getElementById("editId").value;

    fetch(`http://localhost:8080/becas/${id}`, {
        method: "PATCH",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            nombre: document.getElementById("editNombre").value,
            montoTotal: parseFloat(document.getElementById("editMonto").value),
            mensualidad: parseFloat(document.getElementById("editMensualidad").value),
            duracionMeses: parseInt(document.getElementById("editDuracion").value),
            periodicidad: document.getElementById("editPeriodicidad").value,
            estadoConvocatoria: document.getElementById("editEstado").value
        })
    })
    .then(() => {
        cargarBecas();
        bootstrap.Modal.getInstance(document.getElementById('modalEditar')).hide();
    });
}