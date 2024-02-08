<%-- 
    Document   : index
    Created on : Jan 25, 2024, 7:36:41 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<%@page import="model.Bet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/styleindex.css" rel="stylesheet" type="text/css"/>
        <script>
//            let van = null;
            function setActionValue(action, moneyvalue1,moneyvalue2, choicee) {
                const money1 = document.getElementById(moneyvalue1);
                const money2 = document.getElementById(moneyvalue2);
                const color = document.getElementById(action);
                const choose = document.getElementById(choicee);
                var sum = parseInt(money1.value, 10) + 20000;
                choose.value = action;
//                if(van !== null) {
//                    van.style.borderColor = "green";
//                }               
                color.style.borderColor = "red";  
                money1.value = sum;
                money2.value = sum;
//                van = color;
            }
            
            let isImageVisible = true;

            function toggleImage() {
                const image1 = document.getElementById("img1");
                const image2 = document.getElementById("img2");
                const image3 = document.getElementById("img3");
                const nap = document.getElementById("nap");            
                image1.style.opacity = 1;
                image2.style.opacity = 1;
                image3.style.opacity = 1;
                nap.style.top = "-393px";
            }

        </script>
    </head>

    <body>
        <%
            List<String> listRan = (List<String>) request.getAttribute("listRan");
            if (listRan == null) {
                listRan = (List<String>) request.getSession().getAttribute("listRan");
            }

            // If listRan is still null, initialize an empty list
            if (listRan == null) {
                listRan = new ArrayList<>();
                listRan.add("tom");
                listRan.add("bau");
                listRan.add("cua");

            }

            List<Integer> moneyDefault = (List<Integer>) request.getAttribute("moneyResult");
            if (moneyDefault == null) {
                moneyDefault = (List<Integer>) request.getSession().getAttribute("moneyResult");
            }
            if (moneyDefault == null) {
                moneyDefault = new ArrayList<Integer>();
                moneyDefault.add(1000000);
            }
            request.getSession().setAttribute("moneyResult", moneyDefault);

            // Store the updated student list in the session
            request.getSession().setAttribute("listRan", listRan);


        %>
        <div class="flex" style="background-image: url(image/nen4.jpg);">
            <div class="top" style="background-image: url(image/nen1.png); background-size: 80%;   background-repeat: no-repeat;  background-position: center center;margin-top: -43px;">
            <img src="image/nap.png" id="nap"/>
            <div class="roll">             
            <%                 
                String source1 = "image/" + listRan.get(0) + ".jpg";
                String source2 = "image/" + listRan.get(1) + ".jpg";
                String source3 = "image/" + listRan.get(2) + ".jpg";
            %>                  
                    <img src="<%= source1%>" id="img1">
                    <img src="<%= source2%>" id="img2">
                    <img src="<%= source3%>" id="img3">
            </div>
              <div class="button_roll">
                <form action="TaiXiuServlet" method="get">
                    <input type="submit" name="action" value="LẮC" class="button-left">
                </form>
                <h1><%= moneyDefault.get(moneyDefault.size() - 1) %> VND</h1>  
                <button onclick="toggleImage()" class="button-left">MỞ</button>
                  
            </div>
        </div>
            <div class="middle">
                <div class="dice" > 
                    <div>
                        <button onclick="setActionValue('nai','nai1','nai2','naichoice'); submitForm();" id="nai" class="buttonchoose">
                            <img src="image/nai.jpg" class="choose" alt="Button Image">
                        </button>
                        <input type="number" value="0" class="money-input" id="nai1" readonly="readonly" name="moneyValues"/>
                    </div>
                    <div>
                        <button onclick="setActionValue('bau','bau1','bau2','bauchoice'); submitForm();" id="bau"  class="buttonchoose">
                            <img src="image/bau.jpg" class="choose"alt=""/>
                        </button>
                       
                        <input type="number" value="0" class="money-input" id="bau1" readonly="readonly" name="money"/>
                    </div>
                    <div>
                        <button onclick="setActionValue('ga','ga1','ga2','gachoice'); submitForm();" id="ga"  class="buttonchoose">
                            <img src="image/ga.jpg" class="choose" alt=""/>
                        </button>
                       
                        <input type="number" value="0" class="money-input" id="ga1" readonly="readonly" name="money"/>
                    </div>
               </div>
               <div class="dice" >
                   <div>
                        <button onclick="setActionValue('ca','ca1','ca2','cachoice'); submitForm();" id="ca"  class="buttonchoose">
                             <img src="image/ca.jpg" class="choose" alt="Button Image">
                         </button>

                       <input type="number" value="0" class="money-input" id="ca1" readonly="readonly" name="money"/>
                    </div>
                   <div>
                        <button  onclick="setActionValue('cua','cua1','cua2','cuachoice'); submitForm();" id="cua"  class="buttonchoose">
                             <img src="image/cua.jpg" class="choose"alt=""/>
                         </button>
                       
                       <input type="number" value="0" class="money-input" id="cua1" readonly="readonly" name="money"/>
                    </div>
                   <div>
                        <button  onclick="setActionValue('tom','tom1','tom2','tomchoice'); submitForm();" id="tom"  class="buttonchoose">
                             <img src="image/tom.jpg" class="choose" alt=""/>
                         </button>
                      
                       <input type="number" value="0" class="money-input" id="tom1" readonly="readonly" name="money"/>
                    </div>
            </div>
                <form action="Respone" method="get" class="form-bottom">
                    <div class="money-button">
                        <input type="hidden" id="naichoice" name="choice" value="not">
                        <input type="hidden" id="bauchoice" name="choice" value="not">
                        <input type="hidden" id="gachoice" name="choice" value="not">
                        <input type="hidden" id="cachoice" name="choice" value="not">
                        <input type="hidden" id="cuachoice" name="choice" value="not">
                        <input type="hidden" id="tomchoice" name="choice" value="not">
<!--                        <input type="number" name="money" class="inputmoney" value="50"> -->

                        <input type="hidden" value="0" class="money-input" id="nai2" readonly="readonly" name="money"/>
                        <input type="hidden"  value="0" class="money-input" id="bau2" readonly="readonly" name="money"/>
                        <input type="hidden"  value="0" class="money-input" id="ga2" readonly="readonly" name="money"/>
                        <input type="hidden"  value="0" class="money-input" id="ca2" readonly="readonly" name="money"/>
                        <input type="hidden"  value="0" class="money-input" id="cua2" readonly="readonly" name="money"/>
                        <input type="hidden"  value="0" class="money-input" id="tom2" readonly="readonly" name="money"/>
                                               
                        <input type="submit" class="button-right" name="action" value="CƯỢC"">
                        <input type="text" value="" class="message"/>
                    </div>
                    
                </form>
                
        </div>
    </div>
    </body>
</html>
