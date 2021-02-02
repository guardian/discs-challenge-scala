package discs


object Visualise {
  def generateHtml(points: List[Point], discs: List[Disc]): String = {
    val pointEls = points.map { point =>
      s"""<circle class="point" cx='${point.x}' cy='${1000 - point.y}' r='2' fill='black'
         |data-label='${point.label}' data-radius='-' data-position='x=${point.x}, y=${point.y}' data-pinned="false"
         |onmouseover="highlight(this);"
         |onmouseout="unHighlight(this);"
         |onclick="togglePin(this);"
         |/>""".stripMargin
    }
    val discEls = discs.map { disc =>
      s"""<circle class="disc" cx='${disc.centre.x}' cy='${1000 - disc.centre.y}' r='${disc.radius}'
         |data-label='${disc.centre.label}' data-radius='${disc.radius}' data-position='x=${disc.centre.x}, y=${disc.centre.y}' data-pinned="false"
         |onmouseover="highlight(this);"
         |onmouseout="unHighlight(this);"
         |onclick="togglePin(this);"
         |fill='blue' fill-opacity="0.4" stroke="blue" stroke-width="1" />""".stripMargin
    }
    s"""<html>
       |<head>
       |  <title>Discs answer</title>
       |  <style>
       |    input.pinned-disc-info {
       |      padding: 5px;
       |      border: solid 1px #006666;
       |      background-color: #f7f7f7;
       |    }
       |    label {
       |      display: block;
       |      float: left;
       |      min-width: 100px;
       |    }
       |  </style>
       |  <script>
       |    function highlight(el) {
       |      if (el.getAttribute('data-pinned') !== 'true') {
       |        el.setAttribute('fill', 'green');
       |        el.setAttribute('stroke', 'green');
       |      }
       |    }
       |    function unHighlight(el) {
       |      var colour = el.classList.contains("disc") ? "blue" : "black";
       |      if (el.getAttribute('data-pinned') !== 'true') {
       |        el.setAttribute('fill', colour);
       |        el.setAttribute('stroke', colour);
       |      }
       |    }
       |    function togglePin(el) {
       |      document.querySelector('[name=current-label]').value = '';
       |      document.querySelector('[name=current-radius]').value = '';
       |        document.querySelector('[name=current-position]').value = '';
       |      console.log(el, el.getAttribute('data-pinned'));
       |      if (el.getAttribute('data-pinned') == 'true') {
       |        unPinAll();
       |      } else {
       |        unPinAll();
       |        el.setAttribute('data-pinned', 'true');
       |        el.setAttribute('fill', 'red');
       |        el.setAttribute('stroke', 'red');
       |        document.querySelector('[name=current-label]').value = el.getAttribute("data-label");
       |        document.querySelector('[name=current-radius]').value = el.getAttribute("data-radius");
       |        document.querySelector('[name=current-position]').value = el.getAttribute("data-position");
       |      }
       |    }
       |    function unPin(el) {
       |      var colour = el.classList.contains("disc") ? "blue" : "black";
       |      el.setAttribute('data-pinned', 'false');
       |      el.setAttribute('fill', colour);
       |      el.setAttribute('stroke', colour);
       |    }
       |    function unPinAll() {
       |      document.querySelector('.pinned-disc-info').value = '';
       |      [].forEach.call(document.querySelectorAll("circle"), function(el) {
       |        unPin(el);
       |      });
       |    }
       |  </script>
       |</head>
       |<body>
       |  <p>
       |    <div>
       |      <label for="current-label">Label</label>
       |      <input type="text" class="pinned-disc-info" name="current-label" value="" />
       |    </div>
       |    <div>
       |      <label for="current-label">Radius</label>
       |      <input type="text" class="pinned-disc-info" name="current-radius" value="" />
       |    </div>
       |    <div>
       |      <label for="current-label">Position</label>
       |      <input type="text" class="pinned-disc-info" name="current-position" value="" />
       |    </div>
       |  </p>
       |  <svg style="margin: 10px; background-colour: #f7f7f7; border: solid 1px #ccc;" height="1000" width="1000">
       |    <rect width="100%" height="100%" fill="#f7f7f7"/>
       |    ${discEls.mkString("\n")}
       |    ${pointEls.mkString("\n")}
       |  </svg>
       |</body>
       |</html>
     """.stripMargin
  }
}
