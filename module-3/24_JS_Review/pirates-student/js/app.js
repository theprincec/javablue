/*
* Add Events and functions to move the Ship and Win the game
*/

// Creates the Grid -- this should only occur after the DOM loads
createGrid();


/**
 * Reset the Game
 */
function resetGame() {

    // Create the Obstacles
 
    // Inform the user they can start

   // Set the starting location of the boat and treasure

}


/**
 * Creates the game grid
 */
function createGrid() {

    const frame = null; // get a reference to the frame

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
    const row = null; // create the row and add it to the frame
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
   // Add code to create the grid Squares and add them to the row
    
}




/**
 * Adds random obstacles to a game cell
 * 
 * @param {HTMLElement} cell 
 */
function addObstacles(cell) {
    // remove any existing pirates or icebergs
 
    const rand = Math.floor(Math.random() * 100) + 1;

    if (rand > 85) {
        // Add pirates here
    } else if (rand > 80) {
        // Add iceberg here
    } 
}




