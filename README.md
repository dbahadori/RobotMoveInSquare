# RobotMoveInSquare
A project based on spring boot and MongoDB for moving two robot in a square with four main movements.
There is two endpoints, one for sending command using post request and another for getting agent position.
Rules:
-The agent cannot perform an action that moves it to a position occupied by another agent.
-An action that takes the agent out of the square is not allowed too.
