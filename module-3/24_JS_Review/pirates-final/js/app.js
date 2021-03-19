/*
* Add Events and functions to move the Ship and Win the game
*/

// Creates the Grid -- this should only occur after the DOM loads
document.addEventListener('DOMContentLoaded', () => {
    createGrid();

    document.querySelector('body').addEventListener('keydown', (event) => {
        switch(event.key) {
            case 'w': 
                moveShipUp();
                break;
            case 'a': 
                moveShipLeft();
                break;
            case 's': 
                moveShipDown();
                break;
            case 'd':  
                moveShipRight();
                break;
        }
    });

    document.getElementById('resetButton').addEventListener('click', (event) =>{
        resetGame();
        event.preventDefault();
    });
});



function moveShipRight() {
    const ship = getShipLocation();
    const right = ship.nextElementSibling;
    moveShip(ship, right);
}

function moveShipLeft() {
    const ship = getShipLocation();
    const right = ship.previousElementSibling;
    moveShip(ship, right);
}

function moveShipDown() {
    const ship = getShipLocation();
    const rowBelow = ship.parentElement.nextElementSibling;
    const newLocation = getUpperOrLowerElementAtSameIndex(ship, rowBelow);
    moveShip(ship, newLocation);
}

function moveShipUp() {
    const ship = getShipLocation();
    const rowAbove = ship.parentElement.previousElementSibling;
    const newLocation = getUpperOrLowerElementAtSameIndex(ship, rowAbove);
    moveShip(ship, newLocation);
}

function getUpperOrLowerElementAtSameIndex(ship, newRow) {
    let elementAtIndex = null;
    if (newRow != null) {
        const originalIndex = Array.from(ship.parentNode.children).indexOf(ship);
        elementAtIndex = newRow.childNodes[originalIndex];
    }
    return elementAtIndex;
}


function moveShip(oldLocation, newLocation) {
    if (isWin(newLocation)) {
        win();
    } else if (isLoss(newLocation)) {
        lose();
    } else if (canMoveToElement(newLocation)) {
        oldLocation.classList.remove('boat');
        newLocation.classList.add('boat');
    }

}

function canMoveToElement(newLocation) {
    if (newLocation == null 
        || newLocation.classList.contains('pirate')
        || newLocation.classList.contains('iceberg')) {
        return false;
    }
    return true;
}

function isWin(nextLocation) {
    return nextLocation.classList.contains('treasure');
}

function win() {
    const announce = document.querySelector('h1.announce');
    announce.innerText = 'You Win!';
    announce.classList.add('winText');
    getShipLocation().classList.remove('boat');
}

function isLoss(nextLocation) {
    return (nextLocation.classList.contains('pirate') ||
        nextLocation.classList.contains('iceberg'));
}

function lose() {
    const announce = document.querySelector('h1.announce');
    announce.innerText = 'You Sunk!';
    announce.classList.add('winText');
    const ship = getShipLocation();
    ship.classList.remove('boat'); 

    ship.classList.add('boat_explosion');

    setTimeout( () => {
        ship.classList.remove('boat_explosion');
        ship.classList.add('boat_sunk')
    }, 250)

}

function getShipLocation() {
    return document.getElementById('frame').querySelector('.boat');
}

/**
 * Reset the Game
 */
function resetGame() {

    resetBoat();

    // Create the Obstacles
    createObstacles();

    // Inform the user they can start
    const announce = document.querySelector('h1.announce');
    announce.innerText = 'Play!';
    announce.classList.remove('winText');
   
    // Set the starting location of the boat and treasure
    const frame = document.getElementById('frame');
    frame.firstElementChild.firstElementChild.classList.add('boat');
    frame.lastElementChild.lastElementChild.classList.add('treasure');
}

function resetBoat() {
    const ship = getShipLocation();
    if (ship != null) {
        ship.classList.remove('boat');
    }
    const shipSunk = document.getElementById('frame').querySelector('.boat_sunk');
    if (shipSunk != null) {
        shipSunk.classList.remove('boat_sunk');
    }
}



/**
 * Creates the game grid
 */
function createGrid() {

    const frame = document.getElementById('frame');

    // Add Code to create the game grid
    for (let i = 0; i < 10 ; i++) {
        buildRow(frame); 
    }
    resetGame();
}

/**
 * Builds the grid rows
 * @param {HTMLElement} frame 
 */
function buildRow(frame) {
    const row = document.createElement('div');
    row.classList.add('row');
    frame.insertAdjacentElement('beforeend', row);
    for (let i = 0; i < 10 ; i++) {
        buildSquare(row, i); 
    }    
}

/**
 * Builds the grid squares 
 * @param {HTMLElement} row 
 * @param {int} count 
 */
function buildSquare(row, count) {
   // Create a Div
   const cell = document.createElement('div');
   // Apply the css class square
   cell.classList.add('square');
   // Insert it onto the row div
   row.insertAdjacentElement('beforeend', cell);
    
}

function createObstacles() {
    // loop over all the cells in all the rows
    // for each cell call addObstacles( cell )
    // Only if not the boat or pirate position
    const rows = document.querySelectorAll('.row');

    rows.forEach( (row, rowIndex) => {
           const cells = row.children;
           Array.from(cells).forEach( (cell, cellIndex) => {
                if (!(rowIndex == 0 && cellIndex == 0) &&
                    !(rowIndex == rows.length - 1 
                        && cellIndex == cells.length - 1)  ) {
                    addObstacles(cell);
                }
           });
    });
}


/**
 * Adds random obstacles to a game cell
 * 
 * @param {HTMLElement} cell 
 */
function addObstacles(cell) {
    // remove any existing pirates or icebergs
    cell.classList.remove('pirate');
    cell.classList.remove('iceberg');

    const rand = Math.floor(Math.random() * 100) + 1;

    if (rand > 85) {
        // Add pirates here
        cell.classList.add('pirate');
    } else if (rand > 80) {
        // Add iceberg here
        cell.classList.add('iceberg');
    } 
}




