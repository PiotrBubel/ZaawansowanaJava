# Zaawansowana Java - N Puzzle

#### Zespół projektowy:

- Alicja Cent
- Paulina Zakrzewska
- Piotr Bubel
- Sebastian Kazmierczak

#### Opis projektu:

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

#### Obsługa bazy:

1. Wejdź na stronę https://www.apachefriends.org/pl/index.html i ściągnij wersję odpowiednią dla swojego systemu operacyjnego.
2. Podczas instalacji postępuj według instrukcji.
3. Po uruchomieniu programu kliknij Start przy module Apache oraz MySQL.
4. Otwórz przeglądarkę i w pasku adresu wpisz "localhost/phpmyadmin".
5. Ściągnij plik z bazą ze strony https://drive.google.com/open?id=0BxLyCPB6lRLrb0ctWVlVQm9Celk
6. Z dostępnych zakładek w przeglądarce wybierz "Import", a następnie Wybierz Plik ze skryptem do tworzenia bazy, który ściągnąłeś w poprzednim punkcie.
7. Kliknij "Wykonaj".
8. Gotowe

#### Uruchomienie aplikacji:

1. Uruchom konsolę w folderze z projektem.
2. W konsoli wpisz: `mvn clean package` lub `mvn clean package -DskipTests`
3. Po zakończeniu kompilacji (oraz ewentualnych testów) w konsoli wpisz: `java -jar target\npuzzle-1.0-SNAPSHOT.jar`
4. Gotowe
