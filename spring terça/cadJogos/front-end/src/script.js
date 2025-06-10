document.getElementById('cadastroForm').addEventListener('submit', CadastrarJogo);

function CadastrarJogo(event) {
    event.preventDefault();

    const name = document.getElementById('gameName').value;
    const platform = document.getElementById('gamePlatform').value;

    fetch('http://localhost:8080/jogos',{
        method: 'POST',
        headers:{
            'Content-Type':'application/json',
        },
        body: JSON.stringify({name, platform}),
    })
        .then(response => response.json())
        .then(data => {
            alert('Jogo Cadastrado com Sucesso');
            document.getElementById('cadastroForm').reset();
        })
        .catch(error => {
            console.error('Erro ao Cadastrar ', error);
        });
}

function PesquisarJogo(){
    const searchId = document.getElementById('gameId').value;
    fetch(`http://localhost:8080/jogos/${searchId}`)
    .then(respose => {
        if(respose.status === 404) {
            return Promise.reject('Jogo não Encontrado');
        }
        return response.json();
    })
    .then ( data => {
        const resultadopesquisa = document.getElementById('resultadopesquisa');
        resultadopesquisa.innerHTML = `
        <h3>Id ${data.id}</h3> 
        <p>Nome: ${data.name}</p>
        <p>Plataforma: ${data.platform}</p>
        `;
    }
)
}