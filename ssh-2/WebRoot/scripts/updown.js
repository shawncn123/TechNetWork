/**
 * 
 */

function checkf(){
    var files =    document.getElementsByName("file");
    if(files[0].value.length!=0){
            return true;
     }else{
        alert("请选择文件");
        return false;
     }
}
function addMore()
{
   var td = document.getElementById("more");
    var br = document.createElement("br");
    var input = document.createElement("input");
    var button = document.createElement("input");
    input.type = "file";
    input.name = "file";
    button.type = "button";
    button.value = "Remove";
     button.onclick = function()
    {
        td.removeChild(br);
        td.removeChild(input);
        td.removeChild(button);
    }
      td.appendChild(br);
    td.appendChild(input);
    td.appendChild(button);
}