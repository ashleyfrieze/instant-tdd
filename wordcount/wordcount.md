# Word Count

Given a series of `String` inputs, output the number of unique words seen.

_Note:_

- words include letters and apostrophes
- capitalization may vary on otherwise identical words
- punctuation of `,` and `.` should be ignored

## Example

> This is a test

Has four words.

> This is a test and a good test.

Has six unique words.

## Implementation

- Empty string has no words
- One word string has one word
- **Multi** (already unique) word string has multi words
- Multi word string with **duplicates** has unique words
- Multi word string with duplicates in **mixed case** has unique words
- Multi word string with duplicates and **punctuation** has correct count
