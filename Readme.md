# Aufgabe 1.4: Bestellliste

## Aufgabenziele
* Diese Aufgabe beschäftigt sich mit einem Refactoring, also mit einer Umprogrammierung einer bestehenden Anwendung unter vollständiger Beibehaltung der Funktionalität zum Zwecke besserer Programmqualität. 
* Ziel dieses Refactorings ist es, dass die Klasse `OrderList` aus der gegebenen Anwendung als wiederverwendbare Komponente nur von Interfaces nicht jedoch von Implementationen abhängig ist. Es soll nach dem Ende des Refactorings möglich sein, eine dritte Implementation von Produkten hinzuzufügen, ohne dass die Klasse `OrderList` angepasst werden muss. 
* Es soll am Ende der Übung eine wirkliche Erweiterung realisiert werden. Dabei darf `OrderList` nicht geändert werden.
* Gehen Sie bei der Entwicklung inkrementell vor, d.h. schreiben Sie ein kleines Stück Programm und bringen Sie dieses zum Laufen.

## Arbeitsschritte
1. Laden Sie die Ausgangsanwendung aus gitlab (PdSE/order-list) herunter.
2. Machen Sie sich mit dem bestehenden Code vertraut.
3. Legen Sie in dem neuen Projekt die Pakete `de.nordakademie.orderlist.model`, `de.nordakademie.orderlist.model.factory`, `de.nordakademie.orderlist.model.implementation` und `de.nordakademie.orderlist.frontend` an.
4. Bewegen Sie die Klassen in das zugehörige Package und testen Sie die Anwendung.
5. Entfernen Sie die `main` Methode aus der Bestellliste und erzeugen eine Klasse App, die die main Methode aufnimmt.
6. Machen Sie die Klasse `Product` abstrakt und entfernen die Methodenrümpfe von `print` und `getPrice`. Machen Sie diese Methoden abstrakt. Testen Sie die Anwendung.
7. Erzeugen Sie ein Interface `IProduct`, das von `Product` implementiert wird. Welche Methoden gehören ins Interface, welche in die abstrakte Klasse?
8. Ersetzen Sie die Referenzen auf `Product` in Bestellliste durch `IProduct`. Testen Sie die Anwendung.    
9. Erzeugen Sie ein Interface `IProductFactory` mit den Methoden `createIProduct()` und `getProductType()`.
10. Implementieren Sie die Klassen `MaterialFactory` und `ServiceFactory`, die selbstverständlich `IProductFactory` implementieren. Verwenden Sie den Code aus `orderMaterial` und `orderService` aus `OrderList`.
11. Die Klasse `OrderList` erhält nun eine Exemplarvariable `productFactories` vom Typ `IProductFactory[]` und eine Setter Methode für die Variable.
12. Füllen Sie die Variable `productFactories` mittels der Setter Methode in der main Methode von `App` mit einem Array aus einer `MaterialFactory` und einer `ServiceFactory`. 
13. Verändern Sie den Ausgabedialog und die Auswahlbearbeitung unter Verwendung von `productFactories`.
14. Löschen Sie `orderMaterial` und `orderService` aus `OrderList`. Testen Sie Ihre Anwendung.
15. Definieren Sie eine neue Produktart Ihrer Wahl. Erzeugen Sie eine geeignete Factory Implementation. Sie sollten in der Lage sein, die Bestellliste in main mit dieser neuen Factory zu versorgen, Ihre Anwendung sollte nun mit der neuen Produktart umgehen können.
