This repository hosts the example app that is used in the series articles
that I've published on Medium, titled "CLEAN-up your Activities".
These articles
> explore ways to keep the Activities in an Android app "clean"
(both in the sense of readable, maintainable and concise code, as well as
in the sense of applying correctly the principles of "clean architecture".

The narrative of the articles starts off from a "naive"
implementation and then we gradually refactor the code. Here's the list of
relevant branches, and in parenthesis the part of the series in which it is
discussed):

- `naive_mvp`: The initial naive implementation (Part I)
- `decouple_framework`: The first refactoring that decouples the Activity
from the Android Framework (Part I)
- `decouple_permissions`: The second refactoring that decouples the Activity
from the runtime permissions request system (Part II)

