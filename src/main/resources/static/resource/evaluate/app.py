from browser import window, document, ajax, console #type:ignore
from browser.local_storage import storage # type: ignore

def execute_code(code):
    exec_context = {}

    exec(code, exec_context)

    return exec_context

