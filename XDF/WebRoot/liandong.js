 /*  
**    ==================================================================================================  
**    类名：CLASS_LIANDONG_YAO  
**    功能：多级连动菜单  
**    
**    作者：YAODAYIZI  

**    ==================================================================================================  
**/          
  function CLASS_LIANDONG_YAO(array)
  {
	   //数组，联动的数据源
      this.array=array; 
      this.indexName='';
      this.indexsubName='';
      this.obj='';
      //设置子SELECT
    // 参数：当前onchange的SELECT ID，要设置的SELECT ID
      this.subSelectChange=function(selectName1,seleteSubName,selectName2)
      {
      //try
      //{
          var obj1=document.all[selectName1];
          var obj2=document.all[selectName2];
          var obj3=document.all[selectName1];
          var objName=this.toString();
          var me=this;

        	  obj1.onchange=function()
        	  {
        		  
        		  me.optionChange(this.options[this.selectedIndex].value,seleteSubName,obj2.id)
        	  }
          	


      }


      //设置第一个SELECT
    // 参数：indexName指选中项,indexSubNameselectName指select的ID
      this.firstSelectChange=function(indexName,indexsubName,selectName)  
      {
            this.obj=document.all[selectName];
            this.indexName=indexName;
            this.indexsubName = indexsubName;
            this.optionChange(this.indexName,indexsubName,this.obj.id)

      }

// indexName指选中项,selectName指select的ID
      this.optionChange=function (indexName,indexsubName,selectName)
      {
          var obj1=document.all[selectName];
          var obj3=document.all[selectName];
          var me=this;
          obj1.length=0;
          obj1.options[0]=new Option("请选择",'');
          for(var i=0;i<this.array.length;i++)
          {        
        	  	 if(this.array[i][0]==indexName && this.array[i][1] == indexsubName) 
                  {
                    obj1.options[obj1.length]=new Option(this.array[i][3],this.array[i][2]);
                  }
        	  
          }
      }
  }
