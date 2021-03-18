const colors = document.getElementById("colors");
colors.addEventListener("click", event => {
  if (event.target.nodeName.toLowerCase() === "li") {
    event.target.style.backgroundColor = event.target.innerText;
  }
});

colors.addEventListener("dblclick", event => {
	if (event.target.nodeName.toLowerCase() === "li") {
		event.target.style.backgroundColor = 'transparent';
	}
});

function addOrange() {
	const orange = document.createElement('li');
	orange.innerText = 'Orange';
	colors.appendChild(orange);
}

document.addEventListener('DOMContentLoaded', () => {
	const button = document.getElementById('btnAddOrange');
	button.addEventListener('click', addOrange);

	document.getElementById('btnAddAnotherColor').addEventListener('click', addColor);

});

function addColor() {
		const newColor= document.createElement('li');
		newColor.innerText = document.getElementById('colorpicker').value;
		colors.appendChild(newColor);

}