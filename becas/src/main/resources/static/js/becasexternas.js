document.addEventListener("DOMContentLoaded", () => {
    cargar();
});

// CARGAR TODAS
function cargar() {
    fetch("http://localhost:8080/becas_externas")
        .then(res => res.json())
        .then(data => pintarTabla(data))
        .catch(err => console.error("Error:", err));
}

// BUSCAR POR ID
function buscar() {
    const id = document.getElementById("buscarId").value;

    if (!id) {
        alert("Ingresa un ID");
        return;
    }

    fetch(`http://localhost:8080/becas_externas/${id}`)
        .then(res => res.json())
        .then(data => pintarTabla([data]));
}

// PINTAR TABLA
function pintarTabla(lista) {

    let tabla = document.getElementById("tabla");
    tabla.innerHTML = "";

    if (!Array.isArray(lista)) return;

    lista.forEach(b => {

        tabla.innerHTML += `
        <tr>
            <td>${b.id}</td>
            <td>${b.nombre}</td>
            <td>${b.montoTotal}</td>
            <td>${b.mensualidad}</td>
            <td>${b.duracionMeses}</td>
            <td>${b.periodicidad}</td>
            <td>${b.estadoConvocatoria}</td>
            <td>${b.tipoBeca}</td>
            <td>
                <button class="btn btn-warning btn-sm"
                    onclick="abrirModal(
                        ${b.id},
                        '${b.nombre}',
                        ${b.montoTotal},
                        ${b.mensualidad},
                        ${b.duracionMeses},
                        '${b.periodicidad}',
                        '${b.estadoConvocatoria}',
                        '${b.tipoBeca}'
                    )">
                    Editar
                </button>

                <button class="btn btn-danger btn-sm"
                    onclick="eliminar(${b.id})">
                    Eliminar
                </button>
            </td>
        </tr>
        `;
    });
}

// AGREGAR
function agregar() {

    fetch("http://localhost:8080/becas_externas", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            nombre: document.getElementById("nombre").value,
            montoTotal: parseFloat(document.getElementById("monto").value),
            mensualidad: parseFloat(document.getElementById("mensualidad").value),
            duracionMeses: parseInt(document.getElementById("duracion").value),
            periodicidad: document.getElementById("periodicidad").value,
            estadoConvocatoria: document.getElementById("estado").value,
            tipoBeca: document.getElementById("tipo").value
        })
    })
    .then(() => cargar());
}

// ELIMINAR
function eliminar(id) {
    fetch(`http://localhost:8080/becas_externas/${id}`, {
        method: "DELETE"
    })
    .then(() => cargar());
}

// ABRIR MODAL
function abrirModal(id, nombre, monto, mensualidad, duracion, periodicidad, estado, tipo) {

    document.getElementById("editId").value = id;
    document.getElementById("editNombre").value = nombre;
    document.getElementById("editMonto").value = monto;
    document.getElementById("editMensualidad").value = mensualidad;
    document.getElementById("editDuracion").value = duracion;
    document.getElementById("editPeriodicidad").value = periodicidad;
    document.getElementById("editEstado").value = estado;
    document.getElementById("editTipo").value = tipo;

    new bootstrap.Modal(document.getElementById('modalEditar')).show();
}

// GUARDAR EDICIÓN
function guardarEdicion() {

    let id = document.getElementById("editId").value;

    fetch(`http://localhost:8080/becas_externas/${id}`, {
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
            estadoConvocatoria: document.getElementById("editEstado").value,
            tipoBeca: document.getElementById("editTipo").value
        })
    })
    .then(() => {
        cargar();
        bootstrap.Modal.getInstance(document.getElementById('modalEditar')).hide();
    });
}