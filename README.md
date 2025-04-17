# Milles Bornes

Le principe de ce TP est de coder un Mille(s) Bornes en utilisant les fonctionnalités Java vues en cours.

On notera la typo de nos professeurs, et oui, "Mille" est invariable, il ne prend pas de "s".

## Info étudiant

**Prénom NOM** : Manolo SARDÓ

**Num étu**    : 22205413

**Groupe**     : B12

## Notes de projet

- **Difficulté** : L'obligation d'utiliser Eclipse. Eclipse est un IDE... Techniquement dépassé (il l'a - il me semble - toujours été par ailleurs). C'est un IDE lourd (aussi bien pour le système qu'en utilisation), peu optimisé, mal pensé (il y a - par default - **ÉNORMÉMENT** de redondances dans les meta-fichiers).

- **Difficulté** : L'UML du sujet semble être un arrangement *"maison"* de la norme UML (les indications A, C, E n'apparaissent par exemple dans aucune documentation UML, ni dans le cours, où cette fonctionnalité est montrée autrement. On est obligé de déduire que ça signifie "Abstract", "Concrete", "Enum").

- **Point d'intéret** : Les itérateurs. Principe vu en cours, c'est un outil formidable. Évidemment, nous parlons de Java, donc c'est implémenté syntaxiquement de manière très lourde, mais ça reste un superbe outil.

- **Point d'intéret** : Nous ne sommes pas tenus par la main, nous devons réfléchir (un peu, ça reste plutôt simple pour le moment et tout de même assez guidé) par nous-même, ce qui change d'ILU2 où nous n'avions qu'à transcrire des diagrammes de séquences et de classes beaucoup trop détaillés en Java.

- **Point d'intéret** : Les exceptions. Nous avons vu en cours comment les gérer, mais quasi-systématiquement sur des "cas pathologiques" artificiels. Ici, nous avons des exceptions qui peuvent être lancées par des erreurs de logique, et c'est très intéressant de voir comment les gérer (même si toujours très simple).

- **Difficulté** : Le sujet n'est pas forcément très clair (je pense notamment à la méthode "donnerCartes", pourquoi n'apparaît-elle pas dans le diagramme de classes mais seulement dans une ligne en bas de page ?).

- **Difficulté** : Toujours Eclipse. J'ai l'habitude (comme beaucoup) de coder sur VScode, Sublime voir Vim. J'aime voir la "vrai" arborecence de mes fichiers, j'aime voir mon code tel qu'il est réellement, sans fioritures. Eclipse est un IDE lourd, qui cache beaucoup de choses et nécessite de passer par des menus pour des actions simples. Par ailleur, Eclipse a été créé par des gens ne sachants pas se passer de leurs souris, il n'a pas été pensé pour des programmeurs mais pour des designers.

- **Point d'intéret** : L'héritage. Nous le connaissons "en théorie" déjà très bien, mais - de la même manière que les exceptions - nous ne l'avons vu que sur des cas pathologiques ou des cas absolument simplistes. Ici, nous avons - plus qu'un cas concrêt - un cas pertinent. Néanmoins, il est dommage que le sujet ne nous laisse pas plus de liberté sur l'implémentation de l'héritage, nous avons un diagramme de classes déjà fourni, nous n'avons qu'à le transcrire en Java. Il aurait été intéressant de nous laisser trouver par nous même la meilleure manière de coder l'héritage.

- **Point d'intéret** : La définition de la méthode `equals` avec `instanceof` et `getClass`. L'héritage est vraiment pertinent ici, et c'est très utile de savoir minimiser la redondance de code.

- **Incompréhension** : On nous demande de coder une fonction `checkCount` qui vérifie que le retour de `donnerCartes` correspond à une certaine configuration. Or, `donnerCartes` est **DÉFINIE** selon cette même configuration. Donc `checkCount` ne sert à rien, ou plutôt ne fait que tester si Java fonctionne correctement (À bien y réfléchir, ce n'est pas si bête, on ne sait jamais comment Java peut se comporter ^^).

- **Point d'inintérêt** : La seconde version de la méthode `extraire` : Oui, effectivement, nous avons vu les itérateurs, mais ici, ça n'apporte rien, c'est une perte totale de temps et d'efforts.

- **Point d'agacement** : La convention de nommage... Nous devons coder des fonctions, une fois en français, une fois en anglais, sans qu'il n'y ai de logique ou de cohérence. Déjà que Java est particulièrment verbeux et difficile à lire, si en plus on doit changer de langue à chaque ligne...

- **Difficulté** : L'exercice 3.3 du TP2 est incompréhensible.

- **Point d'agacement** : Il n'est à aucun moment demandé dans le sujet de coder une classe `Cartes` contenant des alias pour les cartes, or, c'est utilisé dans les tests.

- **Incompréhension** : L'exercice 1.5 du TP4 demande que si on a une botte du bon type ET qu'on est prioritaire, alros on ignore l'attaque. Or, dans les règles, seule la botte du bon type est nécessaire.

- **Incompréhension** : La troisième partie du TP 5 nous demande de manipuler des interfaces mais... Ce n'est ni utile, ni pertinent. Les interfaces sont un outil très puissant, mais ici, elles ne servent strictement à rien.