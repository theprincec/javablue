const names = [
    {
        firstName: 'John',
        lastName: 'Fulton'
    },
    {
        firstName: 'Matt',
        lastName: 'Eland'
    },
    {
        firstName: 'Rachelle',
        lastName: 'Rauh'
    }
]

document.addEventListener('DOMContentLoaded', () => {
    const list = document.getElementById('ourList');

    names.forEach( (name) => {
        const li = document.createElement('li');
        li.innerText = `${name.firstName} ${name.lastName}`;
        list.insertAdjacentElement('beforeend', li);
    });


});




