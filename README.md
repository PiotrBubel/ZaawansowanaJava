# Zaawansowana Java - N Puzzle

Zespół projektowy:

- Alicja Cent
- Paulina Zakrzewska
- Piotr Bubel
- Sebastian Kazmierczak

Opis projektu:

Aplikacja okienkowa (Java Swing) implementująca popularną grę logiczną N-Puzzle (Piętnastka).

Funkcjonalności:
- losowanie planszy po podaniu stopnia trudności oraz wielkości planszy (każda wylosowana plansza będzie posiadała rozwiązanie)
- rozwiązywanie planszy przez użytkownika
- automatyczne rozwiązywanie planszy z wykorzystaniem algorytmów:
	- BFS
	- DFS
  - A* - heurystyki: Manhattan Distance i Misplaced
  - IDA* - heurystyki: Manhattan Distance i Misplaced
  - IDDFS - heurystyki: Manhattan Distance i Misplaced
- zapisywanie wyników punktowych, historii rozwiązania planszy (ruchów użytkownika) i czasu rozwiązania do bazy danych
- ranking wyników (statystyki pobierane z bazy danych)
- odtwarzanie ‘powtórki’ z zapisanego rozwiązania
- możliwość wczytania własnego obrazka do podzielenia na elementy do ułożenia (obrazek ładowany przez użytkownika)
