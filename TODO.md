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

Config file syntax:

* connect.host             = 10.1.2.102
* connect.db               = DBNAME
* connect.user             = MY_USER
* connect.password         = plain:qwerty
* filter.default           = false
* filter.column            = ${ not(in(object.name, split('CDATE,UDATE,CUSER,UUSER'))) or (object.table eq 'XXX') and (object.type ne 'BLOB')}
* filter.table             = ${ startsWith(object.name,'MV_') }
* filter.comment           = ${ not(in(object.column, split('CDATE,CUSER'))) }
* filter.constraint.pk     = ${ true }
* filter.constraint.fk     = ${ in(object.table,split('A,B,C')) or in(object.column,split('E,F')}
* filter.constraint.ck     = true
* filter.constraint.un     = true
* filter.index.normal      = true
* filter.index.unique      = true
* filter.function          = true
* filter.procedure         = true
* filter.type              = true
* filter.package           = true
* filter.view.normal       = true
* filter.view.materialized = true
* filter.trigger           = true
* filter.sequence          = true
* filter.job               = true
* filter.schema.ddl        = true
* filter.schema.grants     = true
