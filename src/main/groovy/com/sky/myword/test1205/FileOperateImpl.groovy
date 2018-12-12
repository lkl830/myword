package com.sky.myword.test1205

class FileOperateImpl implements FileOperate {
    @Override
    FileEditDTO create(CommandDTO command) {
        if (!command.isCreate()) {
            throw new RuntimeException("test error!")
        }

        FileEditDTO fileEditDTO=new FileEditDTO()

        if (command.hasFileName()) {
            def path="src/test/resources/${command.getFileName()}"
            File file=new File(path)
            if (file.exists()){
                fileEditDTO = new FileEditDTO(file)
            }
        }


        if (command.isPosition()) {
            String positionParams=command.getPositionParam()
            if (positionParams == '+'){
                fileEditDTO.cursorToEnd()
            }else if (positionParams.length()>1&&positionParams.contains('/')){
                def regStr=positionParams.substring(2)
                fileEditDTO.setCursorToRegStart(regStr)

            }else {
                def lineNumber=positionParams.substring(1)
                try{
                    fileEditDTO.setCursorPosition(0,Integer.parseInt(lineNumber)-1)
                }catch (Exception e){
                    throw new RuntimeException()
                }
            }

        } else {
            fileEditDTO.setCursorPosition(0, 0)
        }

        return fileEditDTO
    }
}
