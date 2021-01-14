package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /*
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */

		// ### EXAMPLE:
		int initialNumberOfBirds = 4;
		int birdsThatFlewAway = 1;
		int remainingNumberOfBirds = initialNumberOfBirds - birdsThatFlewAway;

        /*
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */

		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /*
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		int initialRacoons = 6;
		int numberOfRacoonsLeaving = 2;
		int remainingRacoons = initialRacoons - numberOfRacoonsLeaving;
		

        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int flowers = 5;
		int bees = 3;
		int differenceInFlowersAndBees = 2;

        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int initialNumberOfPigeons = 1;
		int AdditionalPigeons = 1;
		int totalNumberOfPigeons = initialNumberOfPigeons + AdditionalPigeons;

        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int initialNumberOfOwls = 3;
		int AdditionalOwls = 2;
		int totalNumberOfOwls = initialNumberOfOwls + AdditionalOwls;
		

        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		int initialNumberOfBeavers = 2;
		int numberOfBeaversGoingSwimming = 1;
		int remainingNumberOfBeavers = initialNumberOfBeavers - numberOfBeaversGoingSwimming;
		

        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int intitialToucans = 2;
		int joiningToucans = 1;
		int totalNumberofToucans = intitialToucans - joiningToucans;

        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int squirrels = 4;
		int nutInTree = 2;
		int differenceOfSquirrelsAndNuts = squirrels - nutInTree;

        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		double amountInQuarters = (.25 * 1);
		double amountInDimes = (.1 * 1);
		double amountInNickels = (.05 * 2);
		double totalAmountOfMoney = amountInQuarters + amountInDimes + amountInNickels;

        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int numberOfBriersMuffins = 18;
		int numberOfMacadamsMuffins = 20;
		int numberOfFlanneryMuffins = 17;
		int TotalNumberOfMuffins = numberOfBriersMuffins+numberOfMacadamsMuffins+numberOfFlanneryMuffins;
		

        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		double costOfYoyo = .24;
		double costOfWhistle = .14;
		double totalCostOfToys = costOfYoyo+costOfWhistle;

        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int largeMallows = 8;
		int smallMallows = 10;
		int totalNumberOfMallows = largeMallows + smallMallows;

        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int hiltSnow = 29;
		int brecknockSnow = 17;
		int differenceOfSnow = hiltSnow - brecknockSnow;

        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
		int startingMoney = 10;
		int costOfTruck = 3;
		int costOfPencil = 2;
		int remainingMoney = startingMoney - costOfTruck - costOfPencil;

        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		int startingMarbles = 16;
		int lostMarbles = 7;
		int remainingMarbles = startingMarbles - lostMarbles;

        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int initialNumberOfSeashells = 19;
		int goalNumberOfSeashells = 25;
		int numberOfSeashellsNeeded = goalNumberOfSeashells - initialNumberOfSeashells;

        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */

        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int initialNumberOfBooks = 38;
		int addedBooks = 10;
		int finalNumberOfSeashells = initialNumberOfBooks+addedBooks;

        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int numberOfLegsPerBee = 6;
		int numberOfBees = 8;
		int totalNumberOfLegs = numberOfLegsPerBee * numberOfBees;
		

        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		double coneCost = .99;
		double numberOfCones = 2;
		double totalCost = coneCost * numberOfCones;

        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int initialNumberOfRocks = 64;
		int numberOfRocksNeeded = 125;
		int rocksNeeded = numberOfRocksNeeded - initialNumberOfRocks;
		

        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int initialNumberOfMarbles = 38;
		int lostMarbless = 15;
		int marblesNeeded = initialNumberOfMarbles - lostMarbless;
		

        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int totalMiles = 78;
		int milesDriven = 32;
		int milesToDrive = totalMiles - milesDriven;

        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
		int minutesShoveledSat = 90;
		int minutesShoveledSun = 45;
		int totalMinuted = minutesShoveledSat + minutesShoveledSun;

        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		int hotdogs = 3;
		double cost = .5;
		double costOfDogs = hotdogs * cost;

        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		double walletTotal = .5;
		double pencilCost = .07;
		double numberOfPencils = (int) walletTotal/pencilCost;
		
		//System.out.println(numberOfPencils);
		
        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int totalButterflies = 33;
		int orangeButterflies = 20;
		int redButterflies = totalButterflies - orangeButterflies;

        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		int katesMoney = 1;
		double candyCost = .54;
		double remainngMoney = katesMoney - candyCost;

        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int initTrees = 13;
		int addTrees = 12;
		int totalTrees = initTrees + addTrees;

        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int daysTil = 2;
		int hrsPerDay = 24;
		int hrsTil = daysTil * hrsPerDay;
		

        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int numOfCousins = 4;
		int piecesOfGumPerCousin = 5;
		int piecesNeeded = numOfCousins * piecesOfGumPerCousin;

        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		double initMoney = 3.00;
		double candyBarCost = 1.00;
		double moneyLeft = initMoney - candyBarCost;

        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int numOfBoats = 5;
		int pplPerBoats = 3;
		int TotalNumOfPpl = numOfBoats * pplPerBoats;

        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int legosAtStart = 380;
		int legosLost = 57;
		int legosLeft = legosAtStart - legosLost;

		
        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int muffinsBaked = 35;
		int muffinsGoal = 83;
		int muffinsToBake = muffinsGoal - muffinsBaked;

        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		int willysCrayon = 1400;
		int lucyCrayon = 290;
		int crayonDifference  = willysCrayon - lucyCrayon;

        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int sticksPerPage = 10;
		int pages = 22;
		int totalStickss = sticksPerPage * pages;

        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		int totalCupcakes = 96;
		int numOfChildren = 8;
		int cupcakesPerChild = totalCupcakes / numOfChildren;

        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
		int totalCookies = 47;
		int cookiesPerJar = 6;
		int leftoverCookeies = totalCookies % cookiesPerJar;
		

        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
		int totalCroissants = 59;
		int croissantsPerNeighor = 8;
		int leftoverCroissants = totalCroissants % croissantsPerNeighor;
		

        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int perTray = 12;
		int totalOatmealCookies = 276;
		int numOfTrays = totalCookies / perTray;
		
		

        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int pretzels = 480;
		int perServing = 12;
		int numOfServings = pretzels / perServing;
		

        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		int numOfLemoncakes = 53;
		int lemoncakesLeftAtHome = 2;
		int cakesPerBox = 3;
		int numOfBoxes = (numOfLemoncakes - lemoncakesLeftAtHome)/ cakesPerBox;

        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		int carrotSticks = 74;
		int sticksPerServing = 12;
		int leftoverCarrots = carrotSticks % sticksPerServing;

        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int teddys = 98;
		int shelfCapacity = 7;
		int numOfFilledShelves = teddys / shelfCapacity;

        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int totalNumOfPictures = 480;
		int picsPerAlbum = 20;
		int albumsNeeded = totalNumOfPictures / picsPerAlbum;

        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int totalCards = 94;
		int cardsPerBox = 8;
		int unboxedCards = totalCards % cardsPerBox;

        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		int fathersBooks = 210;
		int numOfBookshelves = 10;
		int booksPerBookshelf = fathersBooks / numOfBookshelves;

        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		int croissantsBaked = 17;
		int numOfGuests = 7;
		int croissantsPerGuest = croissantsBaked / numOfGuests;

        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */

        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */

        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */


	}

}
