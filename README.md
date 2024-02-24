# SVGO Kotlin
This is an interpretation of the awesome tool [SVGO](https://github.com/svg/svgo), 
written in Kotlin.

## Why?
Very often we find a great tool that would help us in our code, however, 
it is written in a code language incompatible with the one we are using.

[SVGO](https://github.com/svg/svgo), short for **SVG O**ptimizer, is a 
**Node.js library** and command-line application for optimizing SVG files.

As compiled languages cannot use JavaScript libraries without embedding a 
JavaScript engine, this project serves as an interpretation of the library/tool.

This project was created to enable the use of the [SVGO](https://github.com/svg/svgo) 
in compiled languages by leveraging KMP.

## Goals
It is crucial to say that this library does not target to be a replacement
/superset/subset of [SVGO](https://github.com/svg/svgo). The main target is 
to enable usage of it as a library on compiled languages.

Having that said, we have the following goals:

1. Create a kotlin library that enables the usage of the logic inside 
[SVGO](https://github.com/svg/svgo) on languages such as Kotlin and Java.
2. Not to be a 1:1 parse of the [SVGO](https://github.com/svg/svgo) logic, 
but also apply changes in the code by using all available features inside 
the Kotlin language.
3. Keep on track of changes that happened on each released version of 
[SVGO](https://github.com/svg/svgo).
4. Get the same output result as [SVGO](https://github.com/svg/svgo).

Producing a CLI tool or native binary is not a goal for this project. However, 
we may create a native binary for testing purposes on CI, to keep the integrity 
of our code with the [SVGO](https://github.com/svg/svgo).

# Reporting bugs
If you find any bug by using this library, it is our responsibility to identify 
if it was a bug introduced by us or if it is something related to 
[SVGO](https://github.com/svg/svgo), so please **report in our repository first**.

In case we identify that was on our side, we are going to address it as soon 
as possible, and in case we understand it is on [SVGO](https://github.com/svg/svgo)
side, we are going to link an open issue, in case it exists, or ask to create an
issue in the [SVGO](https://github.com/svg/svgo) repository.

> [!IMPORTANT]
> We do not plan to fix issues within the [SVGO](https://github.com/svg/svgo) logic 
> on our side before they address it.

# Usage
As this is a Kotlin library, the usage of this library will differ from the usage 
of [SVGO](https://github.com/svg/svgo), which was built on top of JavaScript.

TBD.

# License and Copyright
This software is released under the terms of the [MIT license](LICENSE).
