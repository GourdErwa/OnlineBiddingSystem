<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!-- Footer -->
<footer class="footer" style="margin-top: 15px">
    <p>© Company 2016</p>
    主题:&nbsp;
    <select id="themeSwitchover">
        <option value="" selected>Bootstrap</option>
        <option value="Cerulean">Cerulean</option>
        <option value="Cosmo">Cosmo</option>
        <option value="Darkly">Darkly</option>
        <option value="Flatly">Flatly</option>
        <option value="Journal">Journal</option>
        <option value="Lumen">Lumen</option>
        <option value="Paper">Paper</option>
        <option value="Readable">Readable</option>
        <option value="Sandstone">Sandstone</option>
        <option value="Simplex">Simplex</option>
        <option value="Slate">Slate</option>
        <option value="Spacelab">Spacelab</option>
        <option value="Superhero">Superhero</option>
        <option value="United">United</option>
        <option value="Yeti">Yeti</option>
    </select>
</footer>

<script>

    $("#themeSwitchover").val('${sessionScope.themeSwitchover}');

    $("#themeSwitchover").on("change", function () {

        $.ajax({
            type: "POST",
            url: "<%=basePath%>" + "themeSwitchover",
            data: {
                "themeSwitchover": this.value
            },
            dataType: "json",
            success: function (data) {
                window.location.reload();
            }

        });

    });

</script>
