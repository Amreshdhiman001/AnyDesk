from flask import Flask, render_template
from github_metrics import get_github_metrics

app = Flask(__name__)

@app.route('/')
def index():
    metrics = get_github_metrics()
    return render_template('dashboard.html', metrics=metrics)

if __name__ == '__main__':
    app.run(debug=True)
