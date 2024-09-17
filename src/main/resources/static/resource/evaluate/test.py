from browser import document, html, window, ajax, console # type:ignore
from browser.local_storage import storage # type:ignore
import io
import sys, javascript# type:ignore
from contextlib import contextmanager
from traceback import format_exception


@contextmanager
def redirect_stdio():
    try:
        sys.stdin, sys.stdout = io.StringIO(), io.StringIO()
        yield sys.stdin, sys.stdout
    finally:
        sys.stdin, sys.stdout = sys.__stdin__, sys.__stdout__

def on_complete(req):
    window.location.href = "http://localhost:8080/"


matric = document['matric'].value
result = {}

def run(event):
    editor = document["textarea"].value
    process = storage["process"]
    code = f"{editor}\n{process}"
    try:
        source = compile(code, "<code>", "exec")
    except SyntaxError as e:
        pass
    else: 
        with redirect_stdio() as (stdin, st):
            try:
                 exec(source, result)
            except BaseException as e:
                traceback = format_exception(e) # type: ignore
                del traceback[1]
            finally:
                s = st.getvalue()
    finally:
        print(result['res'])
        res = f'{{"matric": "{matric}", "score": {result["res"]}}}'
        print(res)
        req = ajax.Ajax()
        req.bind('complete', on_complete)
        req.open('POST', '/post', True)
        req.set_header('content-type', 'application/json')
        req.send(res)

submit = document["submit"]

submit.bind("click", run)