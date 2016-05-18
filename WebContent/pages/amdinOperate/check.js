
function checkform()
{
	if($("#file").val() == "") 
	{
		alert("请选择要上传的花朵的图片！");
		return false;
	}
	if(document.getElementById('description').value.length=='')
    {
		alert("花朵描述不能为空哦，亲！");
		return false;
    }
	 if(document.getElementById('price').value.length=='')
    {
		alert("价格不能为空哦，亲！");
		return false;
    }
	if(document.getElementById('phone').value.length=='')
    {
		alert("花朵编号不能为空哦，亲！");
		return false;
    }
	    
}
