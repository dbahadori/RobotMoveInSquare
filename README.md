# Robot Move In Square
A web based project based on spring boot and MongoDB for moving robots in a square with four main movements.
There is two endpoints, one for sending command using post request and another for getting agent position.
### Rules
1. The agent cannot perform an action that moves it to a position occupied by another agent.
2. An action that takes the agent out of the square is not allowed.
3. Each agent can only move one step in each action.
