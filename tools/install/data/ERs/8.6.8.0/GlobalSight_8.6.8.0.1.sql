# GBS-4053:Base Text Filter Permissions

UPDATE permissiongroup SET PERMISSION_SET = CONCAT(PERMISSION_SET,'424|') WHERE LOCATE('|292|',PERMISSION_SET)<>0 AND LOCATE('|424|',PERMISSION_SET)=0;

UPDATE permissiongroup SET PERMISSION_SET = CONCAT(PERMISSION_SET,'425|') WHERE LOCATE('|292|',PERMISSION_SET)<>0 AND LOCATE('|425|',PERMISSION_SET)=0;

UPDATE permissiongroup SET PERMISSION_SET = CONCAT(PERMISSION_SET,'426|') WHERE LOCATE('|292|',PERMISSION_SET)<>0 AND LOCATE('|426|',PERMISSION_SET)=0;

commit;
