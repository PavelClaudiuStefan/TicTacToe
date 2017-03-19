# TicTacToe
Game made with java (swing library)


###Sa se scrie un joc X si 0. Jocul se va desfasura intr-un JFrame, casutele unde se va da click vor fi butoane si jucatorii pentru X si 0 vor putea sa isi scrie numele.

Jocul este lansat si ruleaza pana la terminare, apoi tot programul se termina.

1.Realizati cele de mai sus, fara validarea jocului (nu se verifica daca X sau 0 au castigat, ci se joaca pana toate casutele sunt pline).

2.Adaugati un dialog (modal) care sa spuna ca jocul s-a terminat.

3.Realizati verificarea daca X sau 0 a castigat si opriti jocul in acel moment.

4.Modificati dialogul astfel incat sa fie afisat : Popescu a castigat (daca Popescu a castigat) sau Remiza, in caz de remiza.

5.Modificati programul astfel incat jocul sa se reseteze automat (numele introduse raman) atunci cand userul inchide dialogul modal.

6.Modificati programul astfel incat jocul sa fie salvat (ordinea in care s-a facut click pe diferitele butoane) intr-un fisier. Numele fisierului va fi introdus in dialogul modal. Fisierul este re-creat de fiecare data (nu ne intereseaza daca exista deja sau nu). Puteti salva ca text datele sau binar (serializare ca text sau binar).

7.Adaugati o fereastra de intampinare cu doua butoane: Joc nou si Instant Replay. Joc nou lanseaza logica de mai sus, Instant replay va incarca o salvare de la punctul 6.

8.Implementati Instant Replay, cu un delay de 2 secunde intre mutarile jucatorilor.

9.Adaugati o optiune de control a vitezei de replay, care sa permita si viteze negative (back). Adaugati butoane pentru next move, previous move, si pause (setare viteza 0 si apoi userul poate sa solicite manual o miscare in fata sau in spate).
