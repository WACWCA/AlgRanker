# AlgRanker
AlgRanker is a tool for quickly filtering and ranking 2x2 Rubik's Cube Algorithms. 2x2 Algorithms are notated such as (R U2 R' U' R' F R F'). [More info on notation](https://ruwix.com/the-rubiks-cube/notation/).

FINAL.txt contains a list of hundreds of "Approved" algorithms, which are used by speedcubers currently. From this list, information is gathered about how these moves work together. The number of probability for each 3 move sequence is recorded. Algorithms can then be given a score based on their similarity to the Approved Algorithms. An algorithm that closely resembles approved algorithms will recieve a higher score. 
An algorithm that needs to be tested, it will receive a score for each move in it's sequence based on the likelihood of that move occuring given the prior several moves.

Ex: Alg: R U2 R' U' F2 U' F' 

When evaluating the score for the 3rd move in the sequence, the probability of an R U2 being followed by an R' may be 0.21 based on the Approved algorithms data collected earlier. The log of that probability is then added to the algorithms overall score.

## Running the Program
- Use [Ksolve Online](https://cubing.net/ksolve.js/) (or download KSolve++ for command line use) to generate several thousand algorithms for a given case. Copy the output. Extraneous input will be filtered out.
- Paste into textbox
![SDfDS](/images/algsorter1.PNG)
- Click run to view results
![SDfDS](/images/algsorter2.PNG)


