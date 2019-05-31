/*
  1. EL :表达式. JSP直接支持 ,可以使用此表达式 ,在jsp页面中,便捷的 获取数据.
     EL表达式的格式：
         ${EL表达式内容}
         相当于  使用 ${}  替代了 <%%>

    EL中提供  域对象对应的 对象.
    request  --> requestScope
    session  --> sessionScope
    application --> applicationScope

    使用格式 :
    xxxScope.keyName

    简化格式:
    直接使用 keyName 可以取值 , xxxScope 省略.
    特殊情况 :
    key 相同时 , 查找顺序从域最小对象开始, 找到为止.
   ===============================================
   bean : ${u.name}
   list : ${l[0]}
   map  : ${m.key} 或者 ${m['key']}



  2. JSTL : 标签库. 对标签的扩展, 便捷在jsp中 编写 if ,for 等语句.
    JSTL 是 JSP支持扩展标签库 .引入方式:
        1. 导入jar包 .
            jstl.jar , standard.jar

        2. 页面引入标签
         <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
          引入标签后 , 可以是  jstl提供的标签
          <c:xx></c:xx>

    JSTL使用 : 通过标签 来解决  <%if(){ }%> 问题 .
    将 if 语句, for 语句的逻辑 迁移到标签格式上!!!

    if标签

     <c:if test="${num%2==0}">
        <font color="green"> 韭菜 </font>
    </c:if>

    test 是其重要属性 , 表示boolean值的判断 ,
    true , 执行 <c:if> 标签体中内容 , false 则不执行.




    foreach标签 :
      <c:forEach var="i" begin="0" end="${num}" step="1" >
           ${i} <br>
      </c:forEach>
      var : 表示初始化变量
      begin : 表示开始的值
      end : 表示结束的边界值(包含).
      step : 布局 ,1表示 ++ ,  2 表示 i+=2 ..
      标签体中, 使用 ${i} 获取变量值.




       <!-- 遍历   集合 值 <User>  ,加入 序号 -->
        <c:forEach var="u" items="${l2}" varStatus="vs" >
            ${vs.count} --  ${u.name} <br>
        </c:forEach>

        var : 表示初始化变量  , 表示 集合中元素对象
        items : 表示集合.
        varStatus : 表示循环的状态对象 , 它的count属性 表示计数器, 从1开始,递增.
        标签体中, 使用 ${u} 获取 对象 , u.name 获取属性值等.

  ======================================================================

   MVC 设计模式 :
   M : module 模型 -- javaBean对象.
   V : view  视图  -- jsp页面 , html页面
   C : Controller  控制  -- Servlet


 */
public class Demo {
}
