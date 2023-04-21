# Group members' names:
        Sean-Michael, Jah St. Aimee, Maurice Rivers
        # SimpleSnakeGame


        ## Initialization and main method:
        the main method and the constructor of the SimpleSnakeGame class are responsible for the initialization of the game.
        Initialization in the SimpleSnakeGame class constructor:
        The constructor of the SimpleSnakeGame class sets up the initial configuration of the game.
        It sets the preferred size of the JPanel, the background color, and makes the JPanel focusable to receive key events.
        It also adds a KeyAdapter to handle user input for controlling the snake's movement.
        After setting up the JPanel, it calls the startGame() method to initialize the game state,
        create the first apple, and start the game timer.


        Main method:
        The main method is the entry point of the Java application. It creates a new JFrame, which is the main window of the GUI,
        and a new instance of the SimpleSnakeGame class. The SimpleSnakeGame JPanel is then added to the JFrame.
        The JFrame is configured with a title, set to be non-resizable, packed to fit the JPanel's content, centered on the
        screen, and made visible.
        ## Class variables:
        Size: An integer representing the size of the game board in pixels ,Unit_Size:An integer representing the size of each unit(snake segment and apple)in pixels
        Game_Units: An integer representing the total number of units in the game board(9000)
        Delay: An integer representing the delay between each game update in millieseconds(100 ms in this game)
        x and y: Integer arrays representing the x an dy coordinates of the snakes body parts. The size of each array is equal to the total number of units in the game board
        bodyParts: An integer representing the initial number of body parts of the snake (3)
        applesEaten:An integer representing the number of apples eaten by the snake.
        appleX and appleY: Integers representing the x an y coordinates of the apple on the game board.
        direction: A char representing the current direction of the snake (R for right)
        running: A boolean representing whether the game is running or not. Initialized as false.
        timer: A javax.swing.Timer object responsible for managing the game loop by firing ActionEvent at regular intervals specified by Delay
        NewApple method uses Math.Random to generate random positions for the apple.



        ## SimpleSnakeGame constructor:

        this.setPreferredSize(new Dimension(SIZE, SIZE));//Sets the preferred size of the game panel using the setPreferredSize method taking a new Dimension object with the size constant as both width and height
        this.setBackground(Color.BLACK);//Sets the background color of the game panel to black using the setBackground method
        this.setFocusable(true);//Makes the game panel focusable using the setFocusable() method, which allows it to receive keyboard input events.
        this.addKeyListener(new MyKeyAdapter());//Adds a custom key listener to the game panel using the addKeyListener() method. This key listener is an instance of the MyKeyAdapter class, which is defined later in the code. The key listener processes keyboard events to control the snake's movement direction.
        this.setFocusable(true);//Makes the game panel focusable using the setFocusable() method, which allows it to receive keyboard input events.
        startGame();//Calls the startGame() method, which initializes the game state, places the first apple on the game board, sets the running flag to true, and starts the game loop timer.

        ## startGame method:
        The startGame() method initializes the game state and starts the game loop. Specifically, it performs the following tasks:
        Calls the newApple() method, which generates a new apple at a random position on the game board.
        Sets the running flag to true, indicating that the game is now running.
        Creates a new Timer object with the specified DELAY (100 milliseconds) and the current instance of SimpleSnakeGame as the ActionListener. This timer is responsible for managing the game loop by firing an ActionEvent at regular intervals.
        Starts the timer, which begins the game loop by repeatedly calling the actionPerformed() method after each DELAY interval.
        The startGame() method is responsible for setting up the initial game state and starting the game loop.
        It places the first apple on the board, sets the running flag, and starts the timer to manage the game loop. This method is called in the constructor of the SimpleSnakeGame class, effectively starting the game when an instance of the class is created.





        ## newApple method:
        The newApple() method is responsible for generating a new apple at a random position on the game board. It performs the following tasks:

        appleX = (int) (Math.random() * (SIZE / UNIT_SIZE)) * UNIT_SIZE;//Calculates a random x-coordinate for the apple. It generates a random integer between 0 (inclusive) and the number of horizontal units on the board (exclusive) by using Math.random(). Then, it multiplies the random integer by the UNIT_SIZE to get the actual x-coordinate on the game board in pixels.

        appleY = (int) (Math.random() * (SIZE / UNIT_SIZE)) * UNIT_SIZE;//Calculates a random y-coordinate for the apple in the same way as the x-coordinate. It generates a random integer between 0 (inclusive) and the number of vertical units on the board (exclusive), and then multiplies it by the UNIT_SIZE.

        The newApple() method ensures that the apple's position is aligned with the grid by using the UNIT_SIZE in the calculation. This method is called initially when the game starts and every time the snake eats an apple to place a new apple on the game board.


        ## paintComponent method:
        This method is a part of the JPanel class and is automatically called by the Swing framework when the panel needs to be painted or updated. The paintComponent() method in the SimpleSnakeGame class overrides the default implementation and calls the draw() method to render the game elements. It also calls super.paintComponent(g) at the beginning, which clears the panel and paints its background.
        ## draw method:
        draw(Graphics g) method:
        This method is responsible for rendering the game elements (grid, apple, and snake) on the panel. If the game is running, it draws the grid lines, the apple (red oval), and the snake (green rectangles) on the panel. If the game is not running (game over), it calls the gameOver() method to display the "Game Over" text.

        ## move method:
        This method is responsible for updating the snake's position based on its current direction. It moves the snake's body by updating the position of each body part to the position of the part in front of it, starting from the tail to the head. Then, it updates the position of the snake's head based on the current direction ('U' for up, 'D' for down, 'L' for left, and 'R' for right
        ## checkApple method:
        This method checks whether the snake's head has collided with the apple. If the head's x and y coordinates match the apple's coordinates, it means the snake has eaten the apple. In this case, the method increments the bodyParts and applesEaten variables, and then calls the newApple() method to generate a new apple at a random position.
        ## checkCollisions method:
        The checkCollisions() method is responsible for detecting whether the snake's head has collided with its body or the game board's borders. If a collision is detected, the method sets the running variable to false, which stops the game.


        Check for collisions with the snake's body:
        The method iterates through the snake's body parts, starting from the end, and checks if the x and y coordinates of
        the head (x[0] and y[0]) are equal to the coordinates of any other body part (x[i] and y[i]).
        If a match is found, it means the head has collided with the body, and the running variable is set to false.
        Check for collisions with the game board's borders:
        The method checks if the x or y coordinate of the head is outside the game board's boundaries (0 to SIZE).
        If the head's x or y coordinate is less than 0 or greater than or equal to SIZE,
        it means the head has collided with the border, and the running variable is set to false.
        Stop the timer if the game is not running:
        If the running variable is set to false due to a collision, the method stops the game's timer.
        The checkCollisions() method is called in the actionPerformed() method,
        which is executed at each game loop iteration.
        This ensures that the game constantly checks for collisions and stops when necessary.

        ## gameOver method:
        he gameOver(Graphics g) method is responsible for displaying the "Game Over" message on the screen
        when the game is no longer running (i.e., the snake has collided with its body or the game board's borders).
        This method takes a Graphics object as an argument, which is used to draw the text on the screen.

        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 30));//Set the color and font for the "Game Over" text:
        The method sets the drawing color to red and the font to "Ink Free", bold, with a size of 30.

        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SIZE - metrics.stringWidth("Game Over")) / 2, SIZE / 2);//
        Calculate the position of the "Game Over" text:
        The method calculates the horizontal position of the text by subtracting the width of the text from the game board's size
        and dividing the result by 2. This ensures that the text is horizontally centered on the game board.
        Draw the "Game Over" text on the screen:
        The method calls the drawString() method on the Graphics object to draw the "Game Over" text at the calculated position.






        ## actionPerformed method:
        he actionPerformed(ActionEvent e) method is part of the ActionListener interface and is called whenever an action event
        occurs, such as when a button is clicked or a timer goes off.
        In the context of the SimpleSnakeGame, this method serves as the main game loop,
        which is executed at regular intervals determined by the game's timer (with a delay of 100 milliseconds).

        Here's a breakdown of what the actionPerformed(ActionEvent e) method does:
        Check if the game is running:
        If the running variable is set to true, the game loop will execute the following methods in sequence:

        move(): Update the position of the snake based on its current direction.
        checkApple(): Check if the snake has eaten an apple, increase the snake's body length and the applesEaten counter, and
        generate a new apple.
        checkCollisions(): Check for collisions between the snake's head and its body or the game board's borders and stop the
        game if necessary.
        Repaint the game board:
        Regardless of whether the game is running or not, the method calls the repaint() method to redraw the game board.
        This ensures that the game board is constantly updated to reflect the snake's movement, the apple's position,
        and the "Game Over" text if the game has ended.
        By using the ActionListener interface and the actionPerformed() method, the game loop is synchronized with the system
        clock and runs at a constant frame rate. This ensures that the game runs smoothly and consistently on different systems
        and platforms.


        ## MyKeyAdapter class:
        The MyKeyAdapter class is responsible for handling keyboard inputs for controlling the snake's movement.
        It overrides the keyPressed(KeyEvent e) method, which is called whenever a key on the keyboard is pressed.

        Inside the keyPressed(KeyEvent e) method, a switch statement checks the key code of the pressed key using e.getKeyCode().
        If the pressed key corresponds to an arrow key (left, right, up, or down), the method updates the snake's direction
        (stored in the direction variable) accordingly, while preventing the snake from moving in the opposite direction of its
        current movement
        The MyKeyAdapter class is added as a key listener to the SimpleSnakeGame panel in the constructor,
        allowing the game to receive and process keyboard events