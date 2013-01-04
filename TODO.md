Result sql files should contain queries to perform following steps:

1. Tables DDLs
  * Create table
  * Columns/Table comments
* Table data DMLs
  * New lines should be converted to chr(13)
  * Dates should be converted to to_date(...) form
  * SQL pieces to insert CLOBS
  * SQL pieces to insert BLOBS
  * SQL pieces to insert LONGS
  * Numbers using '.' as fractional separator
* Constraints
  * Primary keys
  * Foreign keys (+ on update/on delete clause)
  * Checks
  * Unique
* Indicies
  * Normal
  * Unique
* Functions
* Procedures
* Types
* Packages
* Views
* Materialized views
* Triggers
* Sequences
* Jobs
* Schema create sql
* Schema grants sql
