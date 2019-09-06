<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>在线播放器</title>
</head>
<body>
<div>
    <video id="video1" controls width="90%" height="50%" onclick="addNewTextTrack()">
        <source src="video/狠西游第2季-03.mp4" type="video/webm"/>
        <source src="video/狠西游第2季-03.mp4" type="video/mp4"/>
        <source src="video/狠西游第2季-03.mp4" type="video/ogg"/>
        你的游览器不支持video元素
    </video>    
</div>
<script>
    myVid=document.getElementById("video1");
    function addNewTextTrack()
    {
        text1=myVid.addTextTrack("caption");
        text1.addCue(new TextTrackCue("Test text", 01.000, 04.000,"","","",true));
    }
</script>
</body>
</html>