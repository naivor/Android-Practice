  function disp_prompt(v1,v2,v3,v4)
   {

   var msg=v1+"://"+"BridgeImpl:"+v4+"/"+v2+"?"+v3

      prompt(msg,"Bill Gates")
   }

   function onFinish(res){alert(JSON.stringify(res))}