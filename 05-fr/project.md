# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([BR1](#br1)) ([UC3](#uc3))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2)) ([UC5](#uc5))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu. ([UC4](#uc4))
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu. ([UC2](#uc2))

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2)) ([UC5](#uc5))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* [UC2](#uc2): Przekazanie produktu Kupującemu

[Kupujący](#ac2)
* [UC3](#uc3): Zaoferowanie kwoty za produkt wyższej od aktualnie najwyższej oferty
* [UC4](#uc4): Przekazanie należności Sprzedającemu
* [UC5](#uc5): Otrzymanie informacji o wyniku aukcji

---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: Przekazanie produtu Kupującemu

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć przekazania produktu [Kupujący](#ac2)emu.
2. System podaje dane [Kupujący](#ac2)ego.

---

<a id="uc3"></a>
### UC3: Zaoferowanie kwoty za produkt wyższej od aktualnie najwyższej oferty

**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) zgłasza do systemu chęć zaoferowania kwoty za produkt.
2. System prosi o podanie kwoty. 
3. [Kupujący](#ac2) podaje kwotę. 
4. System weryfikuje poprawność kwoty. ([BR1](#br1))
5. System informuje o pomyślnym zaoferowaniu kwoty.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawną kwotę.
* 4.A.1. System informuje o błędnie podanej kwocie.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc4"></a>
### UC4: Przekazanie należności Sprzedającemu

**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) zgłasza do systemu chęć przekazania należności [Sprzedający](#ac1)emu.
2. System podaje dane [Sprzedający](#ac1)ego.

---

<a id="uc5"></a>
### UC5: Otrzymanie informacji o wyniku aukcji 

**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**
1. System podaje [Kupujący](#ac2)emu informację o wyniku aukcji. ([BR2](#br2))

---

<a id="uc6"></a>
### UC6: Otrzymanie informacji o stanie aukcji 

**Aktorzy:** [Kupujący](#ac2), [Sprzedający](#ac1)

---

<a id="uc7"></a>
### UC7: Modyfikacja danych produktu

---

## Obiewkty biznesowe (inaczje obiekty dziedzinowe lub informatycjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

## Macierz CRUDL


| Przypadek użycia                                  | Aukcja | Produkt | ... |
| ------------------------------------------------- | ------ | ------- | --- |
| UC1: Wystawienia produktu na aukcję               |    C   |    C    | ... |
| UC2: Przekazanie produktu Kupującemu              |    D   |    D    | ... |
| UC3: Zaoferowanie kwoty za produkt                |  R, U  |         | ... |
| UC4: Przekazanie należności Sprzedającemu         |    R   |         | ... |
| UC5: Otrzymanie informacji o wyniku aukcji        |    R   |         | ... |
| UC6: Otrzymanie informacji o stanie aukcji        |    R   |    R    | ... |
| UC7: Modyfikacja danych produktu                  |    R   |   R, U  | ... |


