document.addEventListener("DOMContentLoaded", () => {
    cargarBecas();
});

let becasDisponibles = [];

// 🔥 CARGAR BECAS ACTIVAS
function cargarBecas() {

    becasDisponibles = [];

    // 🔵 BECAS UAM
    fetch("http://localhost:8080/becas")
        .then(res => res.json())
        .then(data => {

            console.log("Becas UAM:", data);

            data.forEach(b => {

                if (b.estadoConvocatoria === "ACTIVA") {
                    becasDisponibles.push({
                        id: b.id,
                        nombre: b.nombre,
                        monto: b.montoTotal,
                        tipo: "UAM"
                    });
                }

            });

            // 🔁 BECAS EXTERNAS (URL CORRECTA)
            return fetch("http://localhost:8080/becas_externas");
        })
        .then(res => res.json())
        .then(data => {

            console.log("Becas externas:", data);

            // ⚠️ SI NO ES ARRAY, EVITAMOS ERROR
            if (!Array.isArray(data)) {
                console.error("Respuesta no es lista:", data);
                renderBecas();
                return;
            }

            data.forEach(b => {

                if (b.estadoConvocatoria === "ACTIVA") {
                    becasDisponibles.push({
                        id: b.idBecasExternas || b.id,
                        nombre: b.nombre,
                        monto: b.montoTotal || "N/A",
                        tipo: "EXTERIOR"
                    });
                }

            });

            renderBecas();
        })
        .catch(error => {
            console.error("Error cargando becas:", error);
        });
}

// 🔥 MOSTRAR BECAS
function renderBecas() {

    let contenedor = document.getElementById("lista-becas");
    contenedor.innerHTML = "";

    if (becasDisponibles.length === 0) {
        contenedor.innerHTML = `
            <div class="alert alert-warning text-center">
                No hay becas activas disponibles
            </div>
        `;
        return;
    }

    becasDisponibles.forEach(b => {
        contenedor.innerHTML += `
        <div class="form-check border p-3 rounded mb-2 shadow-sm">

            <input class="form-check-input" type="radio" name="beca"
                value="${b.id}-${b.tipo}">

            <label class="form-check-label w-100">
                <div class="d-flex justify-content-between">

                    <div>
                        <strong>${b.nombre}</strong><br>
                        <small>Monto: $${b.monto}</small>
                    </div>

                    <span class="badge bg-${b.tipo === "UAM" ? "primary" : "success"}">
                        ${b.tipo}
                    </span>

                </div>
            </label>

        </div>
        `;
    });
}

// 🔥 ENVIAR SOLICITUD
function enviarSolicitud() {

    const idAlumno = document.getElementById("idAlumno").value;
    const fechaSolicitud = document.getElementById("fechaSolicitud").value;

    const seleccion = document.querySelector('input[name="beca"]:checked');

    if (!idAlumno || !fechaSolicitud) {
        alert("Completa los datos");
        return;
    }

    if (!seleccion) {
        alert("Selecciona una beca");
        return;
    }

    const [idBeca, tipo] = seleccion.value.split("-");

    let solicitud = {
        fechaSolicitud: fechaSolicitud,
        estado: "ACTIVA",
        idAlumno: parseInt(idAlumno),
        idBecaUAM: null,
        idBecaExterior: null
    };

    if (tipo === "UAM") {
        solicitud.idBecaUAM = parseInt(idBeca);
    } else {
        solicitud.idBecaExterior = parseInt(idBeca);
    }

    fetch("http://localhost:8080/solicitudes", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(solicitud)
    })
    .then(() => {
        alert("Solicitud enviada correctamente");
        cargarSolicitudes();
    });
}

// 🔥 VER SOLICITUDES
function cargarSolicitudes() {
    fetch("http://localhost:8080/solicitudes")
        .then(res => res.json())
        .then(data => renderSolicitudes(data));
}

function renderSolicitudes(lista) {

    let tabla = document.getElementById("tabla-solicitudes");
    tabla.innerHTML = "";

    lista.forEach(s => {

        let beca = "-";

        if (s.idBecaUAM) {
            beca = "UAM (" + s.idBecaUAM + ")";
        } else if (s.idBecaExterior) {
            beca = "Exterior (" + s.idBecaExterior + ")";
        }

        tabla.innerHTML += `
        <tr>
            <td>${s.id}</td>
            <td>${s.fechaSolicitud || ""}</td>
            <td>${s.estado}</td>
            <td>${s.idAlumno}</td>
            <td>${beca}</td>
        </tr>
        `;
    });
}