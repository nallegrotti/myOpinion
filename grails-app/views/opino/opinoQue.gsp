<head>
	<link href=<g:resource dir="css" file="chico-min-0.13.1.css"/> rel="stylesheet"/>
	<link href=<g:resource dir="css" file="opino.css"/> rel="stylesheet"/>
</head>
<body>
	<h1>
		Opinar es gratis
	</h1>
	<ul>
		<li class="firstLine">
			<form method="post">
				<fieldset id="nuevaOpinion">
					<textarea name="msg" placeholder="Opino que..."></textarea>
				</fieldset>
				<button class="ch-btn" type="submit">Por lo menos asi lo veo yo</button>
			</form>
		</li>
		<g:each in="${opiniones}">
			<li>
				<div class="fechaCls">
					${it.dateCreated }
				</div>
				<div>${it.name.capitalize()} opina:</div>
				<div class="ch-Box opinionCls">
					${it.opinion}
				</div>
				<div class="votosCls" id="v${it.id}">
					<span class="puntosCls"> P ${it.puntos?:0} </span>
					<g:remoteLink action="acuerdo" id="${it.id}" before="\$('.votosCls#v${it.id}')[0].innerHTML='Ya votaste'">Me Copa</g:remoteLink>
					<span> - </span>
					<g:remoteLink action="desacuerdo" id="${it.id}" before="\$('.votosCls#v${it.id}')[0].innerHTML='Ya votaste'">Buu</g:remoteLink>
				</div>
			</li>
		</g:each>
	</ul>
	<script type="text/javascript" src=<g:resource dir="js" file="jquery.js"/> ></script>
</body>
