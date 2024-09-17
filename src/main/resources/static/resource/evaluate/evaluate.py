import io
import sys
from contextlib import contextmanager
from traceback import format_exception

from browser import document # type:ignore

text_area = document["textarea"]
run = document["run"]
output = document["output"]
@contextmanager
def redirect_stdio():
    try:
        sys.stdin, sys.stdout = io.StringIO(), io.StringIO()
        yield sys.stdin, sys.stdout
    finally:
        sys.stdin, sys.stdout = sys.__stdin__, sys.__stdout__


def input_(message: str = ""):
    if message:
        sys.stdout.write(message)
        sys.stdout.flush()

    return sys.stdin.readline().rstrip("\n")


def run_code(event):
    source_code = text_area.value

    output_str = error_str = ""
    try:
        code = compile(source_code, "<code>", "exec")
    except SyntaxError as e:
        error_str = ''.join(format_exception(e)) # type: ignore
    else:
        with redirect_stdio() as (stdin, stdout):
            stdin.write("This is input\nlast Line\n")
            stdin.seek(0)
            try:
                exec(code, {"input": input_})
            except BaseException as e:
                traceback = format_exception(e) # type: ignore
                del traceback[1]
                error_str = ''.join(traceback)
            finally:
                output_str = stdout.getvalue()
    finally:
        # error.value = ''{error_str.rstrip()}
        if (error_str):
            error = f'\n>>>{error_str.rstrip()}'
        else:error='' 
        output.value = f'{output_str.rstrip()} {error}'


# error = document["error"]
run.bind("click", run_code)
