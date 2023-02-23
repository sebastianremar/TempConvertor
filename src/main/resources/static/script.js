const leftInput = document.getElementById('idLeftInput');
const rightInput = document.getElementById('idRightInput');

const handleInputChange = () => {
    // Getting values with QuerySelector
    const leftTemp = document.getElementById('idLeftInput').value;
    const rightTemp = Number(document.getElementById('idRightInput').value);

    // Getting temperature units
    const leftElementId = document.getElementById("idTempLeft");
    const leftUnitText = leftElementId.options[leftElementId.selectedIndex].text;

    // Getting temperature units
    const rightElementId = document.getElementById("idTempRight");
    const rightUnitText = rightElementId.options[rightElementId.selectedIndex].text;

    // CASO #1 INPUT ESTA VACIO
    if (leftTemp == null && event.target === leftInput) {
        //  Asumamos que estamos en un estado en el que el usuario tiene en blanco el input
        document.getElementById("idRightInput").value = "";
        return;
    }
    if (rightTemp == null && event.target === rightInput) {
        document.getElementById("idLeftInput").value = "";
        return;
    }

    const leftTempNumber = Number(leftTemp);
    const rightTempNumber = Number(rightTemp);

    // CASO #2 El input es una letra
    if (isNaN(leftTempNumber)) {
        console.log("Input es una letra")
        document.getElementById("idRightInput").value = "";
        return;
    }

    if (isNaN(rightTempNumber)) {
        console.log("Input es una letra")
        document.getElementById("idLeftInput").value = "";
        return;
    }

    let tempToChange;
    let currentUnit;
    let unitToChange;
    let isLeft;
    if (event.currentTarget === leftInput) {
        tempToChange = leftTempNumber;
        currentUnit = leftUnitText;
        unitToChange = rightUnitText;
        isLeft = true;
    } else {
        tempToChange = rightTempNumber;
        currentUnit = rightUnitText;
        unitToChange = leftUnitText;
    }

    const data = {
        value : tempToChange,
        currentUnit : currentUnit,
        unitToChange : unitToChange
    }

    $.ajax('tmp', {
        type: "POST",
        contentType : 'application/json; charset=utf-8;',
        data: JSON.stringify(data),
        success: (res) => {
            const {temp, tempUnit} = res;
            if (isLeft) {
                document.getElementById("idRightInput").value = temp;
            } else {
                document.getElementById("idLeftInput").value = temp;
            }

        },
        error: err => {
            console.log(err);
        }
    });
}
leftInput.addEventListener('keyup', handleInputChange);
rightInput.addEventListener('keyup', handleInputChange);