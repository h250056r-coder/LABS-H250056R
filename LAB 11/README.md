# Lab 11 — HIT Library Desk

**Student:** Tishlee Mvududu  
**Registration:** H250056R  
**Programme:** Software Engineering, Harare Institute of Technology

This small console project brings together the OOP topics from the lab manual. Books and DVDs share the abstract `LibraryItem` type, while each item supplies its own loan period. `Borrowable` describes the borrowing actions, and the `Library` service keeps items, members and current loans in maps.

## Run it

Use JDK 17 or newer from this folder:

```text
javac *.java
java LibraryApp
```

The program creates or updates `library-data.csv` in its current folder. It stores item, member and active loan rows, then reloads them the next time the program starts. CSV fields are quoted so commas and quotation marks in a title or member name are kept correctly. A save is written to a temporary file before replacing the previous file. Loading checks each row and its item/member links before changing the in-memory library; if the file is damaged, the app stops and leaves it for repair instead of replacing it with an empty catalogue.

Each member may have up to three active loans. Books are due after 14 days and DVDs after 7 days. An invalid item type is declined with a prompt, and overdue results show the title, item id, member id and due date.

## Class sketch

```text
                 Borrowable
                     ^
                     |
                 LibraryItem (abstract)
                  /          \
               Book           Dvd

Library  o---- Map of LibraryItem
        o---- Map of Member
        o---- Map of active Loan

Member 1 ---- 0..3 active item ids
Loan   1 ---- 1 LibraryItem and 1 Member
```

`ItemNotAvailableException` and `MemberLimitExceededException` report the two expected borrowing failures. Search uses a stream and sorts matching titles alphabetically. The app saves after each menu action so a normal close or restart keeps the catalogue and active loans.

## Quick checks before submission

Try adding a title with a comma, closing and restarting, then searching for it. Also try borrowing the same item twice, returning it with the wrong member id, and giving one member a fourth active loan. These checks exercise persistence and the main validation rules.
